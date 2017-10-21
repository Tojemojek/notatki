package pl.sda.javawwa.sklepik.exception;

public class OrderException extends Exception {

    public OrderException() {
        super();
    }

    public OrderException(String message) {
        super(message);
    }

    public OrderException(String message, Throwable cause) {
        super(message, cause);
    }

    public OrderException(Throwable cause) {
        super(cause);
    }
}
