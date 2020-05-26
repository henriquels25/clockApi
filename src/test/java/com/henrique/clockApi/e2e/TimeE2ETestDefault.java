package com.henrique.clockApi.e2e;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureWebTestClient
public class TimeE2ETestDefault {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void shouldReturnCurrentDay() {
        webTestClient.get().uri("/time").exchange().expectStatus().isOk()
                .expectBody().jsonPath("time").value((timeString) -> {
            LocalDateTime time = LocalDateTime.parse(timeString);
            LocalDate expectedDate = LocalDate.now();
            assertEquals(expectedDate, time.toLocalDate());
        }, String.class);
    }
}
