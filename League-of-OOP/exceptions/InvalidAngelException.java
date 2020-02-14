package exceptions;

/**
 * Exception thrown when an invalid angel is added to the game.
 * */

public final class InvalidAngelException extends Exception {
    public InvalidAngelException(final String errorMessage) {
        super(errorMessage);
    }
}
