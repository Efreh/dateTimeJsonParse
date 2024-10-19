package com.efr.dateTimeJsonParse.controllers;

import com.efr.dateTimeJsonParse.dto.LocalDateTimeDto;
import com.efr.dateTimeJsonParse.service.DateTimeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.matchesPattern;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DateTimeController.class)
class DateTimeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DateTimeService dateTimeService;

    @Test
    void getCurrentDateTime_ShouldReturnFormattedDateTime() throws Exception {
        // Создаем тестовые данные.
        LocalDateTimeDto mockDateTimeDto = new LocalDateTimeDto(LocalDateTime.now());

        // Мокаем поведение сервиса.
        Mockito.when(dateTimeService.getCurrentDateTime()).thenReturn(mockDateTimeDto);

        // Выполняем GET-запрос и проверяем ответ.
        mockMvc.perform(get("/date")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.localDateTime").value(matchesPattern("\\d{4}:\\d{2}:\\d{2}##:\\d{2}:\\d{2}:\\d{2}:\\d{3}")));
    }
}
