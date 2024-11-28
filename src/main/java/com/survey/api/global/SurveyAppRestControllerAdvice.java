package com.survey.api.global;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@Slf4j
@RestControllerAdvice
public class SurveyAppRestControllerAdvice {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiResponse<?>> handleRuntimeException(RuntimeException e){
        log.error("RuntimeException : ", e);
        ApiResponse<?> response = ApiResponse.fail(ExceptionCode.UNCAUGHT_SERVER_ERROR, e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<?>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        ApiResponse<?> response = ApiResponse.fail(ExceptionCode.INVALID_VALUE, e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(response);
    }

    @ExceptionHandler(SurveyAppException.class)
    public ResponseEntity<ApiResponse<?>> handleApiException(SurveyAppException e){
        ApiResponse<?> response = ApiResponse.fail(e);
        return ResponseEntity.status(e.getHttpStatus())
                .body(response);
    }
}
