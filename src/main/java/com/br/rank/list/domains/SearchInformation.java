package com.br.rank.list.domains;

import java.time.LocalDateTime;

public record SearchInformation(
        String productId,
        String nameSearch,
        String index,
        LocalDateTime createAt,
        LocalDateTime updateAt

) {
    public static SearchInformation of(final String productId, final String nameSearch, final String index) {
        return new SearchInformation(productId, nameSearch, index, LocalDateTime.now(), LocalDateTime.now());
    }
}
