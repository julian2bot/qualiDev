package org.ormi.priv.tfa.orderflow.kernel.product;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;

/**
 * Wrapper immuable pour l'identifiant d'un produit.
 *
 * <p>Ce type encapsule un {@link java.util.UUID} et apporte :
 * - une sémantique typée (évite la confusion avec d'autres UUID dans le code),
 * - une fabrique utilitaire {@link #newId()} pour générer de nouveaux identifiants.
 *
 * <p>Le champ interne est annoté {@link jakarta.validation.constraints.NotNull}
 * pour garantir la validité lors des opérations de validation sur les agrégats/vues.
 *
 * todo doc OK
 */

public record ProductId(@NotNull UUID value) {
    public static ProductId newId() {
        return new ProductId(UUID.randomUUID());
    }
}
