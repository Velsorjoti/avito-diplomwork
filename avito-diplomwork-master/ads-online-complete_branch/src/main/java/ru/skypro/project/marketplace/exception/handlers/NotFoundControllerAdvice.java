package ru.skypro.project.marketplace.exception.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.skypro.project.marketplace.exception.*;

@ControllerAdvice
public class NotFoundControllerAdvice {

    @ExceptionHandler(ObjectNotFoundExeption.class)
    public ResponseEntity<?> notFoundObject(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
