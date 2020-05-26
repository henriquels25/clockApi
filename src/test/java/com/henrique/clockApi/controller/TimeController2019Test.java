package com.henrique.clockApi.controller;

import com.henrique.clockApi.config.Clock2019;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.hamcrest.Matchers.equalTo;

@WebFluxTest(TimeController.class)
@Import(Clock2019.class)
class TimeController2019Test {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void shouldReturnTimeIn2019() {
        webTestClient.get().uri("/time").exchange().expectStatus().isOk()
                .expectBody().jsonPath("time").value(equalTo("2019-04-02T09:24:05"));
    }

}