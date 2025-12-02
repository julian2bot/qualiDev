package org.ormi.priv.tfa.orderflow.cqrs.infra.jpa;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.List;

import org.ormi.priv.tfa.orderflow.cqrs.infra.persistence.OutboxRepository;

import io.quarkus.arc.DefaultBean;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

/**
 * Implémentation JPA du contrat {@link OutboxRepository}.
 *
 * <p>Gère la persistance du pattern Outbox pour garantir la livraison fiable
 * des événements aux consommateurs :
 * - {@code publish()} : persiste une nouvelle entrée Outbox avec état initial,
 * - {@code fetchReadyByAggregateTypeOrderByAggregateVersion()} : exécute une requête
 *   SQL native pour récupérer les événements prêts (considérant le timestamp et
 *   le nombre de tentatives),
 * - {@code delete()} / {@code markFailed()} : mises à jour pour le suivi du cycle de vie.
 *
 * <p>Utilise Panache pour les opérations JPA simplifiées.
 *
 * todo doc OK
 */

@ApplicationScoped
@DefaultBean
public class JpaOutboxRepository implements PanacheRepository<OutboxEntity>, OutboxRepository {
	private static final int DEFAULT_DELAY_MS = 5000;
	private static final String SQL_FETCH_QUERY = loadSQLQueryFromFile("/db/queries/findReadyByAggregateTypeOrderByAggregateVersion.sql");

	@Override
	public void publish(OutboxEntity entity) {
		persist(entity);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<OutboxEntity> fetchReadyByAggregateTypeOrderByAggregateVersion(String aggregateType, int limit,
			int maxRetries) {
		return (List<OutboxEntity>) getEntityManager()
				.createNativeQuery(SQL_FETCH_QUERY, OutboxEntity.class)
				.setParameter("aggregateTypes", aggregateType)
				.setParameter("maxAttempts", maxRetries)
				.setMaxResults(limit)
				.getResultList();
	}

	@Transactional
	@Override
	public void delete(OutboxEntity entity) {
		deleteById(entity.getId());
	}

	@Override
	public void markFailed(OutboxEntity entity, String err) {
		markFailed(entity, err, DEFAULT_DELAY_MS);
	}

	@Transactional
	@Override
	public void markFailed(OutboxEntity entity, String err, int delayMs) {
		update("lastError = ?1, nextAttemptAt = ?2, attempts = attempts + 1 WHERE id = ?3",
				err, Instant.now().plusMillis(delayMs), entity.getId());
	}

	private static String loadSQLQueryFromFile(String classpath) {
		try (InputStream is = JpaOutboxRepository.class.getResourceAsStream(classpath)) {
			return new String(is.readAllBytes(), StandardCharsets.UTF_8);
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}
}
