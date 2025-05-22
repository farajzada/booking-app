package az.edu.turing.bookingapp.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.UUID;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<GlobalErrorResponse> notFoundExceptionHandler(ResourceNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(GlobalErrorResponse.builder()
                        .errorId(UUID.randomUUID())
                        .errorCode("NOT_FOUND")
                        .errorMessage(exception.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build());

    }

    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<GlobalErrorResponse> alreadyExistExceptionHandler(AlreadyExistException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(GlobalErrorResponse.builder()
                        .errorId(UUID.randomUUID())
                        .errorCode("ALREADY_EXIST")
                        .errorMessage(exception.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build());
    }
}
