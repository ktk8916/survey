package com.survey.api.global;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

    private final boolean success;
    private final T data;
    private final String message;
    private final String code;
    private final LocalDateTime time = LocalDateTime.now();

    public static <T> ApiResponse<T> success(T result) {
        return ApiResponse.<T>builder()
                .success(true)
                .data(result)
                .build();
    }

    public static <T> ApiResponse<T> success() {
        return ApiResponse.<T>builder()
                .success(true)
                .build();
    }

    public static <T> ApiResponse<T> fail(SurveyAppException exception) {
        return ApiResponse.<T>builder()
                .success(false)
                .code(exception.getCodeName())
                .message(exception.getMessage())
                .build();
    }

    public static <T> ApiResponse<T> fail(ExceptionCode code, String message) {
        return ApiResponse.<T>builder()
                .success(false)
                .code(code.name())
                .message(message)
                .build();
    }
}