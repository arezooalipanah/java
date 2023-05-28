package questionone.productservice;

public class InvalidProductException extends Exception {
    public InvalidProductException(){}

    public InvalidProductException(String message) {
        super(message);
    }

    public InvalidProductException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidProductException(String message, Throwable cause, boolean enableSuppression, boolean writeStackTrace) {
        super(message, cause, enableSuppression, writeStackTrace);
    }

}