package ru.skypro.project.marketplace.exception.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.skypro.project.marketplace.exception.BadForbiddenException;

@ControllerAdvice
public class BadForbiddenControllerAdvice {

    @ExceptionHandler(BadForbiddenException.class)
    public ResponseEntity<?> badResponce() {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }
}
