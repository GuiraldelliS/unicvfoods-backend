package br.edu.unicv.unicvfoods.api.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.OffsetDateTime;
import java.util.HashMap;

@Getter
@RequiredArgsConstructor
public class AdvisorError {

    private final int status;

    private final HashMap<String, String> errors = new HashMap<>();
    private final OffsetDateTime timestamp = OffsetDateTime.now();

    public void addError(String field, String message) {
        errors.put(field, message);
    }

}