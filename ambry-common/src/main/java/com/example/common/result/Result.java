package com.example.common.result;

import java.time.LocalDateTime;

public record Result<T>(Integer code, String message, T data, LocalDateTime timestamp) {

    public static <T> Result<T> success(T data) {
        return new Result<>(0, "success", data, LocalDateTime.now());
    }

    public static <T> Result<T> fail(String message) {
        return new Result<>(500, message, null, LocalDateTime.now());
    }
}
