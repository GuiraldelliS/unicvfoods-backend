package br.edu.unicv.unicvfoods.api.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.OffsetDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ExceptionResponse(Integer status, OffsetDateTime exceptionDate, String title, List<Field> fields) {
    public record Field(String name, String message) {

    }
}