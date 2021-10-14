package HW11;

public class WrongPasswordException extends RuntimeException {
    public WrongPasswordException() {
    }

    public WrongPasswordException(String exception) {
        super(exception);
    }
}
