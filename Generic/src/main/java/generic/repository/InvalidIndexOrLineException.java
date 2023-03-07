package generic.repository;

public class InvalidIndexOrLineException extends Exception {
    public InvalidIndexOrLineException() {
    }

    public InvalidIndexOrLineException(String message) {
        super(message);
    }

    public InvalidIndexOrLineException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidIndexOrLineException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
