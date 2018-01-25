package pl.kostrowski.autosalon.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

public class CarDto {

    private Integer id;

    @NotNull
    private String brand;

    @NotNull
    private String model;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate productionDate;

    @NotNull
    @Pattern(regexp = "[\\w]{8}-[\\w]{4}-[\\w]{4}-[\\w]{4}-[\\w]{12}")
    private String vin;

    public CarDto() {
    }

    public CarDto(Integer id, String brand, String model, LocalDate productionDate, String vin) {
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
}
