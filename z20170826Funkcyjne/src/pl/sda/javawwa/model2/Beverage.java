package pl.sda.javawwa.model2;

public class Beverage {

    private String name;
    private double price;
    private double capacity;

    private boolean isSoft;

    public Beverage(String name, double price, double capacity, boolean isSoft) {
        this.name = name;
        this.price = price;
        this.capacity = capacity;
        this.isSoft = isSoft;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public boolean isSoft() {
        return isSoft;
    }

    public void setSoft(boolean soft) {
        isSoft = soft;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Beverage beverage = (Beverage) o;

        if (Double.compare(beverage.price, price) != 0) return false;
        if (Double.compare(beverage.capacity, capacity) != 0) return false;
        if (isSoft != beverage.isSoft) return false;
        return name != null ? name.equals(beverage.name) : beverage.name == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(capacity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (isSoft ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Beverage{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", capacity=" + capacity +
                ", isSoft=" + isSoft +
                '}';
    }
}
