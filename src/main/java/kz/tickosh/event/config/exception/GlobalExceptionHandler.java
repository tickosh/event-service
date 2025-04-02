package kz.tickosh.event.config.exception;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import kz.tickosh.event.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;

import java.util.Set;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * Example: handle a custom domain exception "EventNotFoundException"
     */
    @ExceptionHandler(NotFoundException.class)
    public Mono<ResponseEntity<ApiErrorResponse>> handleResourceNotFoundException(
            NotFoundException ex) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ApiErrorResponse errorResponse = new ApiErrorResponse(
                status.value(),
                status.getReasonPhrase(),
                ex.getMessage()
        );
        return Mono.just(ResponseEntity.status(status).body(errorResponse));
    }

    /**
     * Validation exception handler
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handleValidationException(ConstraintViolationException ex) {
        Set<String> errorMessages = ex.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toSet());

        String errorMessage = String.join(", ", errorMessages);
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    /**
     * Catch-all for any unhandled exceptions
     */
    @ExceptionHandler(Exception.class)
    public Mono<ResponseEntity<ApiErrorResponse>> handleGenericException(
            Exception ex) {

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        ApiErrorResponse errorResponse = new ApiErrorResponse(
                status.value(),
                status.getReasonPhrase(),
                ex.getMessage()
        );
        return Mono.just(ResponseEntity.status(status).body(errorResponse));
    }
}
