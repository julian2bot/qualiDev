package org.ormi.priv.tfa.orderflow.kernel.product.persistence;

import java.util.Optional;

import org.ormi.priv.tfa.orderflow.kernel.Product;
import org.ormi.priv.tfa.orderflow.kernel.product.ProductId;
import org.ormi.priv.tfa.orderflow.kernel.product.SkuId;

/**
 * Contrat de persistance pour l'agrégat {@link org.ormi.priv.tfa.orderflow.kernel.Product}.
 *
 * <p>Ce port d'accès aux données définit les opérations de sauvegarde et consultation
 * de l'agrégat Product en base de données :
 * - {@code save()} : persiste un agrégat,
 * - {@code findById()} : récupère un agrégat par son identifiant,
 * - {@code existsBySkuId()} : vérifie l'existence d'un produit par SKU.
 *
 * <p>L'implémentation est réalisée dans `infra/jpa/JpaProductRepository`.
 *
 * todo doc OK
 */

public interface ProductRepository {
    void save(Product product);
    Optional<Product> findById(ProductId id);
    boolean existsBySkuId(SkuId skuId);
}
