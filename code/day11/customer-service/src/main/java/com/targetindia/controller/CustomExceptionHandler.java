package com.targetindia.controller;

import com.targetindia.service.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ServiceException.class})
    public ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request){
        ErrorInfo errInfo = new ErrorInfo(ex.getMessage());
        return super.handleExceptionInternal(ex, errInfo, null, HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}
