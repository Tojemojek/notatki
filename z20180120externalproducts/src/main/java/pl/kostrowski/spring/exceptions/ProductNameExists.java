package pl.kostrowski.spring.exceptions;

public class ProductNameExists extends RuntimeException {

    public ProductNameExists(String message) {
        super(message);
    }

}
