package com.firuz.demo.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class StudentErrorController {
    

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleExceptionsGlobally(Exception e) {
        ErrorDetails error = new ErrorDetails("404 not found", e.getMessage(), LocalDateTime.now());

        return new ResponseEntity<ErrorDetails>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
