package org.ormi.priv.tfa.orderflow.cqrs.infra.persistence;

import java.util.List;

import org.ormi.priv.tfa.orderflow.cqrs.infra.jpa.OutboxEntity;

/**
 * Contrat pour la gestion du pattern Outbox en CQRS.
 *
 * <p>L'Outbox garantit la livraison des événements aux consommateurs (projections,
 * microservices) même en cas de défaillance. Il encapsule les responsabilités :
 * - {@code publish()} : ajouter un événement à la boîte de sortie,
 * - {@code fetchReadyByAggregateTypeOrderByAggregateVersion()} : récupérer les
 *   événements prêts à être traités avec limite et gestion des tentatives,
 * - {@code delete()} : supprimer après traitement réussi,
 * - {@code markFailed()} : marquer un événement comme échoué avec delay de retry.
 *
 * <p>L'implémentation {@link org.ormi.priv.tfa.orderflow.cqrs.infra.jpa.JpaOutboxRepository}
 * gère la persistance JPA et les requêtes SQL natives pour l'efficacité.
 *
 * todo doc OK
 */

public interface OutboxRepository {
    void publish(OutboxEntity entity);
    List<OutboxEntity> fetchReadyByAggregateTypeOrderByAggregateVersion(String aggregateType, int limit, int maxRetries);
    void delete(OutboxEntity entity);
    void markFailed(OutboxEntity entity, String err);
    void markFailed(OutboxEntity entity, String err, int retryAfter);
}
