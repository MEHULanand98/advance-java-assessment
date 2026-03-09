package com.example.exception;

import org.springframework.web.bind.annotation.*;

import org.springframework.http.*;

import java.time.LocalDateTime;
import java.util.*;

@ControllerAdvice
public class GlobalExceptionHandler {

@ExceptionHandler(PolicyNotFoundException.class)

public ResponseEntity<Map<String,Object>> handlePolicyException(
PolicyNotFoundException ex){

Map<String,Object> error = new HashMap<>();

error.put("timestamp",LocalDateTime.now());
error.put("status",404);
error.put("error",ex.getMessage());

return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
}
}