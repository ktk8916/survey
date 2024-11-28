package com.survey.api.global;

import org.springframework.http.HttpStatus;

public class SurveyAppException extends RuntimeException {

    private final ExceptionCode code;

    public SurveyAppException(ExceptionCode code) {
        super(code.getMessage());
        this.code = code;
    }

    public SurveyAppException(ExceptionCode code, String message) {
        super(String.format("%s. %s", code.getMessage(), message));
        this.code = code;
    }

    public SurveyAppException(ExceptionCode code, Throwable throwable) {
        super(code.getMessage(), throwable);
        this.code = code;
    }

    public HttpStatus getHttpStatus() {
        return this.code.getHttpStatus();
    }

    public String getCodeName() {
        return code.name();
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

}
