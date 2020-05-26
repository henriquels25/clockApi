package com.henrique.clockApi.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@TestConfiguration
public class Clock2019 {

    @Bean
    @Primary
    public Clock clock2019() {
        ZonedDateTime zonedDateTime = ZonedDateTime.of(LocalDateTime.
                        of(2019, 4, 2, 9, 24, 5),
                ZoneId.systemDefault());

        return Clock.fixed(zonedDateTime.toInstant(), zonedDateTime.getZone());
    }

}
