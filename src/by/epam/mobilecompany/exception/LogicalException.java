package by.epam.mobilecompany.exception;

/**
 * Created by aterehovich on 5/20/15.
 */
public class LogicalException extends Exception {


    public LogicalException() {
    }


    public LogicalException(String message) {
        super(message);
    }

    public LogicalException(String message, Throwable cause) {
        super(message, cause);
    }

    public LogicalException(Throwable cause) {
        super(cause);
    }

    public LogicalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}




