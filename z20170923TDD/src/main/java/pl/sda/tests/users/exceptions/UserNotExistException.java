package pl.sda.tests.users.exceptions;

public class UserNotExistException extends Exception{

    public UserNotExistException(String message) {
        super(message);
    }
}
