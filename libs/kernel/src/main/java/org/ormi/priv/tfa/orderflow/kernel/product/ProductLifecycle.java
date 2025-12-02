package org.ormi.priv.tfa.orderflow.kernel.product;

/**
 * Énumération représentant les états du cycle de vie d'un produit.
 *
 * <p>Les deux états possibles sont :
 * - {@code ACTIVE} : le produit est opérationnel et peut être modifié/consulté,
 * - {@code RETIRED} : le produit a été retiré du catalogue (état final, immuable).
 *
 * <p>Les transitions possibles : ACTIVE → RETIRED (unidirectionnelle).
 * Les modifications (nom, description) ne sont autorisées que si le produit
 * est à l'état ACTIVE.
 *
 * todo doc OK
 */

public enum ProductLifecycle {
    ACTIVE,
    RETIRED
}
