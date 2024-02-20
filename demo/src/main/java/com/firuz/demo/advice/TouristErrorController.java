package com.firuz.demo.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TouristErrorController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleExceptionGlobally(Exception e) {

    }
}
