package com.br.rank.list.domains;

import java.io.Serializable;
import java.math.BigDecimal;

public record Product(
        String id,
        String code,
        String name,
        BigDecimal price,
        Categories categories,
        boolean promotionActive,
        Promotion promotion,
        SearchInformation searchInformation
) implements Serializable {
}
