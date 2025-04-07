package com.meetime.challenge.expection;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public record ErrorResponse(int status, String error, String message) {

    public static ErrorResponse from(HttpStatus status, String error, String message) {
        return new ErrorResponse(status.value(), error, message);
    }
}