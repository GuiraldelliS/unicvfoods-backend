package br.edu.unicv.unicvfoods.api.exception;

import br.edu.unicv.unicvfoods.domain.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<AdvisorError> handleConstraintViolationException(ConstraintViolationException ex) {

        AdvisorError requestError = new AdvisorError(HttpStatus.BAD_REQUEST.value());

        ex.getConstraintViolations().forEach(violation -> requestError.addError(violation.getPropertyPath().toString(), violation.getMessage()));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(requestError);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    protected ResponseEntity<AdvisorError> handleResourceNotFoundException(ResourceNotFoundException ex) {

        AdvisorError requestError = new AdvisorError(HttpStatus.NOT_FOUND.value());
        requestError.addError("message", ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(requestError);

    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    protected ResponseEntity<AdvisorError> handleHttpRequestMethodNotSupportedException(Exception ex) {
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
    }


    @ExceptionHandler
    protected ResponseEntity<AdvisorError> handleException(Exception ex) {
        AdvisorError requestError = new AdvisorError(HttpStatus.INTERNAL_SERVER_ERROR.value());
        requestError.addError("message", ex.getMessage());
        System.out.println(ex.toString());

        return ResponseEntity.internalServerError().body(requestError);
    }


}
