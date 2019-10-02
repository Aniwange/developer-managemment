package com.vela.developermanagementservice.infrastructure.security;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorResponse {
    LocalDateTime localDateTime;
    String        message;

    public ErrorResponse(LocalDateTime localDateTime, String message) {
        this.localDateTime = localDateTime;
        this.message = message;
    }
}
