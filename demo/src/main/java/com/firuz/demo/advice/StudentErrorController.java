package com.firuz.demo.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class StudentErrorController {
    

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleExceptionsGlobally(Exception e) {
        
    }
}
