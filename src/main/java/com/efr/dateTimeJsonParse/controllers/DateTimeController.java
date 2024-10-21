package com.efr.dateTimeJsonParse.controllers;

import com.efr.dateTimeJsonParse.dto.LocalDateTimeDto;
import com.efr.dateTimeJsonParse.service.DateTimeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DateTimeController {

    private final DateTimeService dateTimeService;

    public DateTimeController(DateTimeService dateTimeService) {
        this.dateTimeService = dateTimeService;
    }

    // Маршрутизация HTTP GET-запросов на /date.
    // Контроллер вызывает сервис для получения текущего времени и возвращает DTO с отформатированными данными.
    @GetMapping("/date")
    public LocalDateTimeDto getCurrentDateTime() {
        return dateTimeService.getCurrentDateTime();
    }
}
