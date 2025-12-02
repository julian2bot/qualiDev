package org.ormi.priv.tfa.orderflow.kernel.product.persistence;

import org.ormi.priv.tfa.orderflow.kernel.product.ProductEventV1;

/**
 * Énumération des versions de schéma d'événement pour le domaine Product.
 *
 * <p>Actuellement, seule la version V1 est définie. Cette énumération permet
 * d'évoluer le schéma d'événement sans casser la rétrocompatibilité, en ayant
 * la possibilité d'ajouter V2, V3, etc. et de gérer les migrations/transformations
 * d'événements en conséquence.
 *
 * todo doc OK
 */

public enum ProductEventVersion {
    V1(ProductEventV1.EVENT_VERSION);

    private final int value;

    ProductEventVersion(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
