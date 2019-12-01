package exceptions;

public final class InvalidMoveException extends Exception {
    public InvalidMoveException(String errorMessage) {
        super(errorMessage);
    }
}
