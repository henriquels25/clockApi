package com.henrique.clockApi.controller;

import com.henrique.clockApi.config.Clock2020;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.hamcrest.Matchers.equalTo;

@WebFluxTest(TimeController.class)
@Import(Clock2020.class)
class TimeController2020Test {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void shouldReturnTimeIn2020() {
        webTestClient.get().uri("/time").exchange().expectStatus().isOk()
                .expectBody().jsonPath("time").value(equalTo("2020-07-18T14:50:00"));
    }

}