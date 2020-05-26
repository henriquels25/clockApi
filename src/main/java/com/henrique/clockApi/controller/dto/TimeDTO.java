package com.henrique.clockApi.controller.dto;

import java.time.LocalDateTime;

public class TimeDTO {

    private LocalDateTime time;

    public TimeDTO(LocalDateTime time) {
        this.time = time;
    }

    public LocalDateTime getTime() {
        return time;
    }
}
