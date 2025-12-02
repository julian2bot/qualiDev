package org.ormi.priv.tfa.orderflow.contracts.productregistry.v1.read;

import java.time.Instant;

/**
 * DTO représentant un élément du flux événementiel en temps réel des changements produits.
 *
 * <p>Utilisé pour les endpoints de streaming WebSocket/SSE :
 * - {@code type} : type d'événement (ProductRegistered, ProductNameUpdated, etc.),
 * - {@code productId} : identifiant du produit affecté,
 * - {@code occuredAt} : timestamp d'occurrence de l'événement.
 *
 * <p>Permet aux clients abonnés de recevoir les mises à jour en temps réel
 * via {@link io.smallrye.mutiny.Multi} ou équivalent.
 *
 * todo doc OK
 */

public record ProductStreamElementDto(
    String type,
    String productId,
    Instant occuredAt
) {
}
