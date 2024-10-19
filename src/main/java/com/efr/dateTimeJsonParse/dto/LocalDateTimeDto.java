package com.efr.dateTimeJsonParse.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class LocalDateTimeDto {

    // Аннотация @JsonFormat задает формат вывода даты/времени в JSON.
    // Использование локали "ru" гарантирует, что формат будет адаптирован для русского языка.
    @JsonFormat(pattern = "yyyy:MM:dd'##':HH:mm:ss:SSS", locale = "ru")
    private LocalDateTime localDateTime;

    // Конструктор класса принимает LocalDateTime для его передачи в объект DTO.
    public LocalDateTimeDto(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
