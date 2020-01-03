package exceptions;

/**
 * Exception thrown when trying to create an invalid land.
 * */
public final class InvalidLandException extends Exception {
    public InvalidLandException(final String errorMessage) {
        super(errorMessage);
    }
}
