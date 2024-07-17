package dev.aaiyvan.authservice.exception;

public class InvalidOrExpiredCodeException extends RuntimeException {

    public InvalidOrExpiredCodeException(final String message) {
        super(message);
    }
}
