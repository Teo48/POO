package exceptions;

public final class InvalidPlayerException extends Exception {
    public InvalidPlayerException(String errorMessage) {
        super(errorMessage);
    }
}
