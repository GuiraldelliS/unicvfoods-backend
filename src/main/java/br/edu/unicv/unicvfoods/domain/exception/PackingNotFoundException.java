package br.edu.unicv.unicvfoods.domain.exception;

public class PackingNotFoundException extends RuntimeException {
    public PackingNotFoundException(String message) {
        super(message);
    }
}
