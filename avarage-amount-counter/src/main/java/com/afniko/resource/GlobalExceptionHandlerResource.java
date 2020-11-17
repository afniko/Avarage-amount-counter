package com.afniko.resource;

import com.afniko.exception.NotSavedSalesAmountInfoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandlerResource extends ResponseEntityExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandlerResource.class);

    @ExceptionHandler(NotSavedSalesAmountInfoException.class)
    public ResponseEntity<Object> handleResourceNotSavedSalesAmountInfoException(NotSavedSalesAmountInfoException e) {
        LOG.debug("In handleResourceNotSavedSalesAmountInfoException - {}", e.getMessage());

        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

}
