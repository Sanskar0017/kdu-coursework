package kdu.sanskar.springjpa.exceptions;

/**
 * Custom exception class extending IndexOutOfBoundsException.
 * Used to handle custom exceptions in the application.
 */
public class RecordNotFoundException extends IndexOutOfBoundsException {

    /**
     * Constructs a new MyCustomException with the specified detail message.
     *
     * @param message the detail message (which is saved for later retrieval by the getMessage() method).
     */
    public RecordNotFoundException(String message) {
        super(message);
    }
}
