package org.ormi.priv.tfa.orderflow.cqrs;

import java.time.Instant;
import java.util.UUID;

/**
 * Conteneur immuable d'un événement de domaine enrichi de métadonnées.
 *
 * <p>L'<code>EventEnvelope</code> encapsule un {@link DomainEvent} avec :
 * - une <b>séquence</b> (typiquement la version/sequence d'agrégat) utilisée pour
 *   ordonner les événements ;
 * - un <b>timestamp</b> d'occurrence généré lors de la construction de l'enveloppe ;
 * - des accesseurs pratiques vers l'<i>aggregateId</i> et l'<i>aggregateType</i>.
 *
 * <p>Usage typique : le Kernel produit une instance via {@link #with(DomainEvent, Long)}
 * après avoir appliqué une transition d'état, puis la persiste dans l'Event Log
 * et la publie aux consommateurs/projections.
 *
 * <p>Garantit l'immuabilité des métadonnées et simplifie la sérialisation/transmission
 * des événements dans l'infrastructure CQRS.
 *
 * todo doc OK
 */

public class EventEnvelope<E extends DomainEvent> {
    private final E event;
    private final Long sequence;
    private final Instant timestamp;

    public EventEnvelope(E event, Long sequence, Instant timestamp) {
        this.event = event;
        this.sequence = sequence;
        this.timestamp = timestamp;
    }

    public UUID aggregateId() {
        return event.aggregateId();
    }
    public String aggregateType() {
        return event.aggregateType();
    }
    public E event() {
        return event;
    }
    public Long sequence() {
        return sequence;
    }
    public Instant timestamp() {
        return timestamp;
    }

    public static <E extends DomainEvent> EventEnvelope<E> with(E event, Long sequence) {
        return new EventEnvelope<>(event, sequence, Instant.now());
    }
}
