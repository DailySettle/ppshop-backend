package mingli.ppshop.Exception;

public class UserEmailExistException extends Exception {
    public UserEmailExistException() {
        super();
    }

    public UserEmailExistException(String errorMessage) {
        super(errorMessage);
    }
}
