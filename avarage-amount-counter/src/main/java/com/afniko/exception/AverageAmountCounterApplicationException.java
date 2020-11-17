package com.afniko.exception;

public abstract class AverageAmountCounterApplicationException extends RuntimeException {

    public AverageAmountCounterApplicationException(String message) {
        super(message);
    }

    public AverageAmountCounterApplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public AverageAmountCounterApplicationException(Throwable cause) {
        super(cause);
    }
}
