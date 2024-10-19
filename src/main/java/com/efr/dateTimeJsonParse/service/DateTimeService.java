package com.efr.dateTimeJsonParse.service;

import com.efr.dateTimeJsonParse.dto.LocalDateTimeDto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DateTimeService {

    // Метод получения текущего времени в формате LocalDateTime.
    // Возвращает DTO с форматированными данными времени.
    public LocalDateTimeDto getCurrentDateTime() {
        // Создание объекта LocalDateTime, который содержит текущее время.
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Возврат DTO-объекта с переданным временем.
        return new LocalDateTimeDto(currentDateTime);
    }
}