package com.moneytransfer.exceptions;

public class InvalidAccountException extends ServiceException{
    public InvalidAccountException(String errorCode) {
        super(errorCode);
    }

    public InvalidAccountException(String message, String errorCode) {
        super(message, errorCode);
    }

    public InvalidAccountException(String message, Throwable cause, String errorCode) {
        super(message, cause, errorCode);
    }

    public InvalidAccountException(Throwable cause, String errorCode) {
        super(cause, errorCode);
    }

    public InvalidAccountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String errorCode) {
        super(message, cause, enableSuppression, writableStackTrace, errorCode);
    }
}
