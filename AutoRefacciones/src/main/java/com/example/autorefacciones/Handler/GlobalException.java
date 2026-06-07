package com.example.autorefacciones.Handler;

import com.example.autorefacciones.Exception.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFound(NotFoundException ex){
        return ResponseEntity.status(404).body(ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String>handleValidation(MethodArgumentNotValidException ex){
        String msg = ex.getBindingResult().getFieldError().getDefaultMessage();
        return  ResponseEntity.badRequest().body(msg);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneric(Exception ex){
        return ResponseEntity.status(500).body("Error interno del servidor");
    }
}
