package br.edu.unicv.unicvfoods.api.exceptionhandler;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.parsing.Problem;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@ControllerAdvice
public class RequestExceptionHandler extends ResponseEntityExceptionHandler {

    private final MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<ExceptionResponse.Field> errorFields = ex.getBindingResult().getAllErrors()
                .stream()
                .map(objectError -> {
                    String name = ((FieldError) objectError).getField();
                    String message = messageSource.getMessage(objectError, LocaleContextHolder.getLocale());
                    return new ExceptionResponse.Field(name, message);
                }).collect(Collectors.toList());

        ExceptionResponse exceptionResponse = new ExceptionResponse(status.value(), OffsetDateTime.now(), "Um ou mais campos foram preenchidos incorretamente.", errorFields);

        return handleExceptionInternal(ex, exceptionResponse, headers, status, request);
        
    }

}
