package com.br.rank.list.domains;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;

public record Promotion(
        String description,
        BigDecimal promotionalPrice,
        Collection<DayAndHour> dayAndHours
) implements Serializable {
}
