package com.firuz.demo.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.firuz.demo.exception.TouristNotFoundException;

@RestControllerAdvice
public class TouristErrorController {

    @ExceptionHandler(TouristNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleExceptionTourist(TouristNotFoundException e) {

        System.out.println("Advice TouristExceptionHandler");
        ErrorDetails error = new ErrorDetails("404 NOT FOUND", e.getMessage(), LocalDateTime.now());

        return new ResponseEntity<ErrorDetails>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleExceptionGlobally(Exception e) {

        ErrorDetails error = new ErrorDetails("404 NOT FOUND", e.getMessage(), LocalDateTime.now());

        return new ResponseEntity<ErrorDetails>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
