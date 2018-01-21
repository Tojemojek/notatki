package pl.kostrowski.spring.entity;

public enum ProductType {

    FOOD("Jedzonko"),DRINK("Picie"),ELECTRONICS("Elektronika");

    private String value;

    ProductType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
