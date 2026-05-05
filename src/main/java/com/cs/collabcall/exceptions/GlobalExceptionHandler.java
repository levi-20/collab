package com.cs.collabcall.exceptions;

import com.cs.collabcall.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(NotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value())
            .body(new ErrorResponse(
                    HttpStatus.NOT_FOUND.getReasonPhrase(),
                    exception.getMessage(),
                    HttpStatus.NOT_FOUND.value(),
                    LocalDateTime.now()
                )
            );
    }

    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<ErrorResponse> handleUserAlreadyExistResponse(AlreadyExistException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT.value())
            .body(new ErrorResponse(
                    HttpStatus.CONFLICT.getReasonPhrase(),
                    exception.getMessage(),
                    HttpStatus.CONFLICT.value(),
                    LocalDateTime.now()
                )
            );
    }
}
