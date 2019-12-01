package exceptions;

/**
 * Exception thrown when an invalid move is casted.
 * */
public final class InvalidMoveException extends Exception {
    public InvalidMoveException(final String errorMessage) {
        super(errorMessage);
    }
}
