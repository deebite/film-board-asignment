package com.filmboard.assignment.controller;


import com.filmboard.assignment.dto.FailReason;
import com.filmboard.assignment.exception.ResourceNotFoundException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<FailReason> handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException) {
        FailReason errors = new FailReason();
        errors.setErrorMessage(resourceNotFoundException.getMessage());
        errors.setStatusCode(String.valueOf(404));
        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }
}
