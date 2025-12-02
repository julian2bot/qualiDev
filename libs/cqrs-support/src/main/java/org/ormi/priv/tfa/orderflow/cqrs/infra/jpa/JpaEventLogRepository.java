package org.ormi.priv.tfa.orderflow.cqrs.infra.jpa;

import org.ormi.priv.tfa.orderflow.cqrs.EventEnvelope;
import org.ormi.priv.tfa.orderflow.cqrs.infra.persistence.EventLogRepository;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.quarkus.arc.DefaultBean;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

/**
 * Implémentation JPA du contrat {@link EventLogRepository}.
 *
 * <p>Cette classe persiste les {@link EventEnvelope} dans la table <code>event_log</code>
 * en utilisant Hibernate/JPA via Panache. Elle :
 * - utilise {@link EventLogJpaMapper} pour transformer l'enveloppe en entité,
 * - injecte {@link ObjectMapper} pour la sérialisation JSON du payload,
 * - applique la transactionnalité via {@code @Transactional}.
 *
 * <p>L'entrée est immédiatement persistée et disponible pour les lectures/projections.
 *
 * todo doc OK
 */

@ApplicationScoped
@DefaultBean
public class JpaEventLogRepository implements PanacheRepository<EventLogEntity>, EventLogRepository {

    private final EventLogJpaMapper mapper;
    private final ObjectMapper objectMapper;

    @Inject
    public JpaEventLogRepository(EventLogJpaMapper mapper, ObjectMapper objectMapper) {
        this.mapper = mapper;
        this.objectMapper = objectMapper;
    }

	@Override
    @Transactional
	public EventLogEntity append(EventEnvelope<?> eventLog) {
		EventLogEntity entity = mapper.toEntity(eventLog, objectMapper);
		persist(entity);
		return entity;
	}
}
