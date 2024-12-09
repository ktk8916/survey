package com.survey.api.global;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ExceptionCode {

    // common
    UNCAUGHT_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "uncaught server error"),
    INVALID_VALUE(HttpStatus.BAD_REQUEST, "invalid value"),

    ;

    private final HttpStatus httpStatus;
    private final String message;
}
