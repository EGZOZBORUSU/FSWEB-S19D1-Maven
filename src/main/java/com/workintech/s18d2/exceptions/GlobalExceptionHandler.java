package com.workintech.s18d2.exceptions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(FruitException.class)
    public ResponseEntity<FruitErrorResponse> handleException(FruitException exc) {
        FruitErrorResponse error = new FruitErrorResponse(exc.getStatus().value(), exc.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(error, exc.getStatus());
    }
    @ExceptionHandler(PlantException.class)
    public ResponseEntity<FruitErrorResponse> handlePlantException(PlantException exc) {
        FruitErrorResponse error = new FruitErrorResponse(exc.getStatus().value(), exc.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(error, exc.getStatus());
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<FruitErrorResponse> handleGeneralException(Exception exc) {
        FruitErrorResponse error = new FruitErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), exc.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
