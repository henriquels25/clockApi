package com.henrique.clockApi.controller;

import com.henrique.clockApi.controller.dto.TimeDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Clock;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/time")
public class TimeController {

    private final Clock clock;

    public TimeController(Clock clock) {
        this.clock = clock;
    }

    @GetMapping
    public Mono<TimeDTO> getCurrentTime() {
        return Mono.just(new TimeDTO(LocalDateTime.now(clock)));
    }
}
