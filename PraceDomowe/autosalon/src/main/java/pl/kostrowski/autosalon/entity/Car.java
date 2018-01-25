package pl.kostrowski.autosalon.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "car")
public class Car {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "production_date", nullable = false)
    private LocalDate productionDate;

    @Column(name = "vin", unique = true, nullable = false)
    private String vin;

    public Car() {
    }

    public Car(Integer id, String brand, String model, LocalDate productionDate, String vin) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.productionDate = productionDate;
        this.vin = vin;
    }

    public Integer getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }

    public String getVin() {
        return vin;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(brand, car.brand) &&
                Objects.equals(model, car.model) &&
                Objects.equals(productionDate, car.productionDate) &&
                Objects.equals(vin, car.vin);
    }

    @Override
    public int hashCode() {

        return Objects.hash(brand, model, productionDate, vin);
    }

}
