package com.ozalp.AI.Generator.Backend.exceptions.handlers;

import com.ozalp.AI.Generator.Backend.common.utilities.results.ErrorResult;
import com.ozalp.AI.Generator.Backend.exceptions.errors.BusinessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    ResponseEntity<?> businessException(BusinessException e) {
        return ResponseEntity.badRequest().body(new ErrorResult(e.getLocalizedMessage()));
    }
}
