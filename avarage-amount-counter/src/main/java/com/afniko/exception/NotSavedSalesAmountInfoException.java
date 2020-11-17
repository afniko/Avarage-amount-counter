package com.afniko.exception;

public class NotSavedSalesAmountInfoException extends AverageAmountCounterApplicationException {

    public NotSavedSalesAmountInfoException(String message) {
        super(message);
    }

    public NotSavedSalesAmountInfoException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotSavedSalesAmountInfoException(Throwable cause) {
        super(cause);
    }
}
