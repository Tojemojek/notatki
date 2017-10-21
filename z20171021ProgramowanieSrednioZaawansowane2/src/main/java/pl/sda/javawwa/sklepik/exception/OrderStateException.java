package pl.sda.javawwa.sklepik.exception;

public class OrderStateException extends OrderException {

    public OrderStateException() {
    }

    public OrderStateException(String message) {
        super(message);
    }

    public OrderStateException(String message, Throwable cause) {
        super(message, cause);
    }

    public OrderStateException(Throwable cause) {
        super(cause);
    }
}
