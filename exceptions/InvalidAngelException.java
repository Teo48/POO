package exceptions;

public final class InvalidAngelException extends Exception {
    public InvalidAngelException(final String errorMessage) {
        super(errorMessage);
    }
}
