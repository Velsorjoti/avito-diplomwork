package ru.skypro.project.marketplace.exception.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.skypro.project.marketplace.exception.IncorrectArgumentException;

public class BadRequestControllerAdvice {
    @ExceptionHandler(IncorrectArgumentException.class)
    public ResponseEntity<?> incorrectArgument() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
