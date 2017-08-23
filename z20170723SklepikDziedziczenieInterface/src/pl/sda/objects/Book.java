package pl.sda.objects;

public class Book extends Product {


    public Book(String name, Integer basePrice, Integer margin, Integer id) {
        super(name, basePrice, margin, id);

    }


    // funckja to string dzięki której jak w system out wywołujemy obiekt to pokazuje nam treść obiektu
    @Override
    public String toString() {
        return "Książka o ID: " + this.getId() + ", title: " + this.getName() + ", price: " + this.getBasePrice() + ", margin: " +this.getMargin();
    }
}
