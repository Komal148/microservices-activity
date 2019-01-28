package com.stackroute.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

    //this annotation is used to map each
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity handleUserNotFoundException(final Exception ex){
        return new ResponseEntity(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UserAlreadyFoundException.class)
    public ResponseEntity handleUserAlreadyFoundException(final Exception ex){
        return new ResponseEntity(ex.getMessage(),HttpStatus.CONFLICT);
    }
}



