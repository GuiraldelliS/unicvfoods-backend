package br.edu.unicv.unicvfoods.domain.exception;

public class MeasurementUnitNotFoundException extends RuntimeException {
    public MeasurementUnitNotFoundException(String message) {
        super(message);
    }
}
