package com.ozalp.AI.Generator.Backend.exceptions.handlers;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.ozalp.AI.Generator.Backend.common.utilities.results.ErrorResult;
import com.ozalp.AI.Generator.Backend.exceptions.errors.BusinessException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    ResponseEntity<?> businessException(BusinessException e) {
        return ResponseEntity.badRequest().body(new ErrorResult(e.getLocalizedMessage()));
    }

    // invalid json
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> handleJsonParseError(HttpMessageNotReadableException ex, WebRequest request) {
        String message = "Invalid data format";

        Throwable mostSpecificCause = ex.getMostSpecificCause();
        if (mostSpecificCause instanceof InvalidFormatException) {
            message = mostSpecificCause.getMessage();
        }

        return new ResponseEntity<>(new ErrorResult(message), HttpStatus.BAD_REQUEST);
    }

    // 1. Validation errors
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationErrors(MethodArgumentNotValidException ex, WebRequest request) {
        List<String> validationErrors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .toList();

        String message = "Invalid field";

        if (!validationErrors.isEmpty()) {
            message = validationErrors.get(0);
        }

        return new ResponseEntity<>(new ErrorResult(message), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        System.out.println("Error: " + ex.getMessage());
        return new ResponseEntity<>(new ErrorResult("An unknown error occurred"), HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
