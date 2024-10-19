package com.efr.dateTimeJsonParse.service;

import com.efr.dateTimeJsonParse.dto.LocalDateTimeDto;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DateTimeServiceTest {

    private final DateTimeService dateTimeService = new DateTimeService();

    @Test
    void getCurrentDateTime_ShouldReturnFormattedDateTime() {
        // Получаем текущее время.
        LocalDateTimeDto dateTimeDto = dateTimeService.getCurrentDateTime();

        // Получаем текущее время для сравнения.
        LocalDateTime now = LocalDateTime.now();

        // Проверяем, что возвращаемое время соответствует ожидаемому формату.
        assertEquals(now.getYear(), dateTimeDto.getLocalDateTime().getYear());
        assertEquals(now.getMonthValue(), dateTimeDto.getLocalDateTime().getMonthValue());
        assertEquals(now.getDayOfMonth(), dateTimeDto.getLocalDateTime().getDayOfMonth());
        assertEquals(now.getHour(), dateTimeDto.getLocalDateTime().getHour());
        assertEquals(now.getMinute(), dateTimeDto.getLocalDateTime().getMinute());
        assertEquals(now.getSecond(), dateTimeDto.getLocalDateTime().getSecond());
        assertEquals(now.getNano() / 1_000_000, dateTimeDto.getLocalDateTime().getNano() / 1_000_000); // Сравнение миллисекунд.
    }
}