package com.henrique.clockApi.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@TestConfiguration
public class Clock2020 {

    @Bean
    @Primary
    public Clock clock2020() {
        ZonedDateTime zonedDateTime = ZonedDateTime.of(LocalDateTime.
                        of(2020, 7, 18, 14, 50, 0),
                ZoneId.systemDefault());

        return Clock.fixed(zonedDateTime.toInstant(), zonedDateTime.getZone());
    }
}
