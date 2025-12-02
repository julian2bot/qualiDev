package org.ormi.priv.tfa.orderflow.kernel.product.persistence;

import java.util.List;
import java.util.Optional;

import org.ormi.priv.tfa.orderflow.kernel.product.ProductId;
import org.ormi.priv.tfa.orderflow.kernel.product.SkuId;
import org.ormi.priv.tfa.orderflow.kernel.product.views.ProductView;

/**
 * Contrat de persistance pour la vue matérialisée {@link ProductView}.
 *
 * <p>Ce port expose les opérations de sauvegarde et recherche des ProductView
 * utilisées par les APIs de lecture :
 * - {@code save()} : persiste ou met à jour une vue,
 * - {@code findById()} / {@code findBySkuId()} : récupération simple,
 * - {@code countPaginatedViewsBySkuIdPattern()} / {@code searchPaginatedViewsOrderBySkuId()} :
 *   recherche paginée par pattern de SKU.
 *
 * <p>L'implémentation est réalisée dans `infra/jpa/ProductViewJpaRepository`.
 *
 * todo doc OK
 */

public interface ProductViewRepository {
    void save(ProductView productView);
    Optional<ProductView> findById(ProductId id);
    Optional<ProductView> findBySkuId(SkuId skuId);
    long countPaginatedViewsBySkuIdPattern(String skuIdPattern);
    List<ProductView> searchPaginatedViewsOrderBySkuId(String skuIdPattern, int page, int size);
}
