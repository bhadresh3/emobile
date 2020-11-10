package com.emobile.Exception;

import com.emobile.Exception.Admin.InvalidRequestIdException;
import com.emobile.Exception.Admin.WrongStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class ErrorAdvisor extends ResponseEntityExceptionHandler {
    @ExceptionHandler(InvalidRequestIdException.class)
    public ResponseEntity<Object> handleCityNotFoundException(
            InvalidRequestIdException ex, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Request Id Not Found");

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(WrongStatusException.class)
    public ResponseEntity<Object> handleNodataFoundException(
            WrongStatusException ex, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Wrong status Provided");

        return new ResponseEntity<>(body, HttpStatus.NOT_ACCEPTABLE);
    }
}
