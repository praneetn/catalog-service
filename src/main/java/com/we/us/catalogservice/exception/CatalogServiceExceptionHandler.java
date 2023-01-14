package com.we.us.catalogservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CatalogServiceExceptionHandler {

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<String> bookNotFoundHandler(BookNotFoundException exception)
    {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BookAlreadyExistsException.class)
    public ResponseEntity<String> bookAlreadyExistsHandler(BookAlreadyExistsException exception)
    {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity< Map<String,String>> validationErrorHandler(MethodArgumentNotValidException exception)
    {
        Map<String,String> map=new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach(error ->{
                String field=((FieldError)error).getField();
                String errorMsg=error.getDefaultMessage();
                map.put(field,errorMsg);
        });
        return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
    }
}
