package com.br.rank.list.domains;

import java.time.LocalTime;

public record DayAndHour(
        Days day,
        LocalTime startTime,
        LocalTime endTime
) {
}
