package exceptions;

/**
 * Exception thrown when an invalid player is added to the game.
 * */
public final class InvalidPlayerException extends Exception {
    public InvalidPlayerException(final String errorMessage) {
        super(errorMessage);
    }
}
