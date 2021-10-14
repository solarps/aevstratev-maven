package HW11;

public class WrongLoginException extends RuntimeException {
    public WrongLoginException() {
    }

    public WrongLoginException(String exception) {
        super(exception);
    }
}
