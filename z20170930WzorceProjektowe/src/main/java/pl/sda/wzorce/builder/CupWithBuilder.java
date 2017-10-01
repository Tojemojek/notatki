package pl.sda.wzorce.builder;

public class CupWithBuilder {

    private int capacity;
    private String shape;
    private String colour;

    public int getCapacity() {
        return capacity;
    }

    public String getShape() {
        return shape;
    }

    public String getColour() {
        return colour;
    }

    public CupWithBuilder(CupBuilder cupBuilder) {
        this.capacity = cupBuilder.capacity;
        this.shape = cupBuilder.shape;
        this.colour = cupBuilder.colour;
    }

    @Override
    public String toString() {
        return "To jest klasa zewnętrzna{" +
                "capacity=" + capacity +
                ", shape='" + shape + '\'' +
                ", colour='" + colour + '\'' +
                '}';
    }

    public static class CupBuilder {
        private int capacity;
        private String shape;
        private String colour;

        public CupBuilder(int capacity) {
            System.out.println("To jest konstruktor klasy wewnętrznej");
            this.capacity = capacity;
        }

        public CupBuilder shape(String shape) {
            System.out.println("To jest metoda klasy wewnętrznej dodająca shape");
            this.shape = shape;
            return this;
        }

        public CupBuilder colour(String colour) {
            System.out.println("To jest metoda klasy wewnętrznej dodająca colour");
            this.colour = colour;
            return this;
        }

        public CupWithBuilder build() {
            System.out.println("To jest metoda klasy wewnętrznej budujące zewnętrzny obiekt");
            return new CupWithBuilder(this);
        }

    }
}
