package org.example.carinventory.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NoCarOnInventoryException extends RuntimeException{
    public NoCarOnInventoryException(String message) {
        super(message);
    }
}
