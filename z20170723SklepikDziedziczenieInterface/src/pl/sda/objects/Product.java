package pl.sda.objects;

//tworzymy klasę abstrakcyjną
//po to żeby mieć wzorzec
// i jak jest potrzeba to wzorując się na niej tworzyć klasy  " rzeczywiste "

public abstract class Product {

    private String name;
    private Integer basePrice;

    private Integer margin;
    private Integer id;

    // konstruktor który będzie we wszystkich stosowany jako domyślny, można go przesłaniać w klasach rzeczywistych
    public Product(String name, Integer basePrice, Integer margin, Integer id) {
        this.name = name;
        this.basePrice = basePrice;
        this.margin = margin;
        this.id = id;
    }


    //wpisujemy tu metody które będą wspólne dla wszystkich klas potomnych
    //tu są metody z implementacją, enie są abstrakcyjne
    public String getName() {
        return name;
    }

    public Integer getBasePrice() {
        return basePrice;
    }

    public Integer getMargin() {
        return margin;
    }

    public Integer getId() {
        return id;
    }
}

