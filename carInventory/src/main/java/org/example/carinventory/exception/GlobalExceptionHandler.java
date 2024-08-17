package org.example.carinventory.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({NoCarOnInventoryException.class})
    public ResponseEntity<?> handleNoCarOnInventoryException(NoCarOnInventoryException e) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(e.getMessage());
    }

    @ExceptionHandler({CarAlreadyExistsException.class})
    public ResponseEntity<?> handleCarAlreadyExistsException(CarAlreadyExistsException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }

    @ExceptionHandler({CarNotFoundException.class})
    public ResponseEntity<?> handleCarNotFoundException(CarNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<?> handleException(Exception e) {
        //TODO: log to console
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An exception occurred: ");
    }

}
