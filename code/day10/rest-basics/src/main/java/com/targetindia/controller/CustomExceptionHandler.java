package com.targetindia.controller;

import com.targetindia.model.ErrorInfo;
import com.targetindia.service.ServiceException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ServiceException.class})
    public ResponseEntity<Object> handleServiceException(Exception ex, WebRequest request) {
        return handleExceptionInternal(ex,
                new ErrorInfo(ex.getMessage()),
                new HttpHeaders(),
                HttpStatus.BAD_REQUEST,
                request);
    }

}
