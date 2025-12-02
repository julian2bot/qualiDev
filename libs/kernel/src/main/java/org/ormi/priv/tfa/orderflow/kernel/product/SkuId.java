package org.ormi.priv.tfa.orderflow.kernel.product;

import jakarta.validation.constraints.NotNull;

/**
 * Wrapper immuable pour un identifiant de SKU (Stock Keeping Unit).
 *
 * <p>Le SKU respecte un format strict : trois caractères majuscules suivi d'un tiret
 * et de cinq chiffres (exemple : "ABC-12345"). Cette validation est appliquée au
 * moment de la construction via un pattern regex.
 *
 * <p>Un produit est identifié de manière unique par son SKU, qui représente une
 * variante spécifique du produit (taille, couleur, version, etc.).
 *
 * @throws IllegalArgumentException si le format du SKU ne correspond pas au pattern
 *
 * todo doc OK
 */

public record SkuId(@NotNull String value) {
    private static final java.util.regex.Pattern SKU_PATTERN =
        java.util.regex.Pattern.compile("^[A-Z]{3}-\\d{5}$");

    public SkuId {
        if (!SKU_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException("Invalid SKU format, expected [Alpha]{3}-[Digit]{5}");
        }
    }
}
