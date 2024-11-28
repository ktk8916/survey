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
    NOT_FOUND(HttpStatus.NOT_FOUND, "not found"),

    // survey
    INVALID_SURVEY_SELECT_OPTION(HttpStatus.BAD_REQUEST, "invalid survey select option")
    ;

    private final HttpStatus httpStatus;
    private final String message;
}
