package org.ormi.priv.tfa.orderflow.cqrs.infra.jpa;

import java.time.Instant;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import com.fasterxml.jackson.databind.JsonNode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entité JPA représentant la table d'event-log (source de vérité immuable
 * des événements de domaine).
 *
 * <p>Chaque enregistrement correspond à un événement produit par un agrégat :
 * - <b>aggregateType</b> et <b>aggregateId</b> identifient l'agrégat cible ;
 * - <b>aggregateVersion</b> représente la version/sequence de l'agrégat au
 *   moment de l'événement ;
 * - <b>eventType</b> et <b>eventVersion</b> identifient le type et la version de
 *   schéma de l'événement ;
 * - <b>payload</b> contient la charge utile sérialisée en JSONB ;
 * - <b>occurredAt</b> est la date/heure d'occurrence.
 *
 * <p>Conventions importantes : les colonnes sont déclarées <code>updatable = false</code>
 * afin d'assurer l'immuabilité historique des événements. Un index sur
 * (aggregate_type, aggregate_id, aggregate_version) permet des recherches
 * efficaces par agrégat et version.
 *
 * <p>À terme, cette entité peut être enrichie avec des informations d'observabilité
 * (correlation, causation, tenant, shardKey) pour faciliter le traçage et le
 * partitionnement.
 *
 * todo doc OK
 */

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
@Table(
    schema = "eventing",
    name = "event_log",
    indexes = {
        @Index(name = "ix_eventlog_aggregate", columnList = "aggregate_type, aggregate_id, aggregate_version")
    })
public class EventLogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false, columnDefinition = "bigserial")
    private Long id;
    @Column(name = "aggregate_type", nullable = false, updatable = false, columnDefinition = "text")
    private String aggregateType;
    @Column(name = "aggregate_id", nullable = false, updatable = false, columnDefinition = "uuid")
    private UUID aggregateId;
    @Column(name = "aggregate_version", nullable = false, updatable = false, columnDefinition = "bigint")
    private Long aggregateVersion;
    @Column(name = "event_type", nullable = false, updatable = false, columnDefinition = "text")
    private String eventType;
    @Column(name = "event_version", nullable = false, updatable = false, columnDefinition = "int")
    private int eventVersion;
    @Column(name = "occurred_at", nullable = false, updatable = false, columnDefinition = "timestamptz")
    private Instant occurredAt;
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "payload", nullable = false, updatable = false, columnDefinition = "jsonb")
    private JsonNode payload;

    /**
     * TODO: implements metadata for observability
     * 
     * - correlation : global tracing of requests
     * - causation : linking related events
     * - tenant : multi-tenancy support (for security, quotas or data tagging purposes)
     * - shardKey : partitioning data for scalability
     */
}
