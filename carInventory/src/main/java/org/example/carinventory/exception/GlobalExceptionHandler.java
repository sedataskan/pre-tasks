package org.example.carinventory.exception;



import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(Handler.class);
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
        //TODO: log to console *
        LOGGER.log(Level.SEVERE, "An exception occurred: ", e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An exception occurred: ");
    }

}
