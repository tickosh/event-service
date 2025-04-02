package kz.tickosh.event.config.exception;

import kz.tickosh.event.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;

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
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Mono<ResponseEntity<ApiErrorResponse>> handleValidationException(
            MethodArgumentNotValidException e) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;

        String errorMessage = e.getBindingResult().getAllErrors()
                .stream()
                .map(error -> {
                    if (error instanceof FieldError) {
                        return ((FieldError) error).getField() + ": " + error.getDefaultMessage();
                    }
                    return error.getDefaultMessage();
                })
                .reduce((first, second) -> first + ", " + second)
                .orElse("Validation error");

        ApiErrorResponse errorResponse = new ApiErrorResponse(
                status.value(),
                status.getReasonPhrase(),
                errorMessage
        );
        return Mono.just(ResponseEntity.status(status).body(errorResponse));
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
