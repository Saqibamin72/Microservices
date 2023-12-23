package com.saqib.user.UserService.exception;

import com.saqib.user.UserService.error.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse>handleResourceNotFoundException(ResourceNotFoundException exception){
        String message=exception.getMessage();
            ApiResponse apiResponse= ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
             return new ResponseEntity<>(apiResponse,HttpStatus.NOT_FOUND);
    }

}
