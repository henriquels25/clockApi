package com.henrique.clockApi.e2e;

import com.henrique.clockApi.config.Clock2020;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.hamcrest.Matchers.equalTo;

@SpringBootTest
@AutoConfigureWebTestClient
@Import(Clock2020.class)
public class TimeE2ETest2020 {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void shouldReturnTimeIn2020() {
        webTestClient.get().uri("/time").exchange().expectStatus().isOk()
                .expectBody().jsonPath("time").value(equalTo("2020-07-18T14:50:00"));
    }
}
