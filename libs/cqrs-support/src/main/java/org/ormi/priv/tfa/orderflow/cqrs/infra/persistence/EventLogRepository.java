package org.ormi.priv.tfa.orderflow.cqrs.infra.persistence;

import org.ormi.priv.tfa.orderflow.cqrs.EventEnvelope;
import org.ormi.priv.tfa.orderflow.cqrs.infra.jpa.EventLogEntity;

/**
 * Contrat pour la persistance des événements de domaine dans le journal des événements.
 *
 * <p>Ce port expose la méthode {@code append()} permettant de persister un événement
 * envelopé dans la table <code>event_log</code>. L'événement est alors disponible pour :
 * - la reconstruction d'agrégats (event sourcing),
 * - les projections vers des vues matérialisées,
 * - l'audit et la traçabilité.
 *
 * <p>L'implémentation {@link org.ormi.priv.tfa.orderflow.cqrs.infra.jpa.JpaEventLogRepository}
 * utilise JPA/Hibernate pour persister l'événement transformé en {@link EventLogEntity}.
 *
 * todo doc OK
 */

public interface EventLogRepository {
    EventLogEntity append(EventEnvelope<?> eventLog);
}
