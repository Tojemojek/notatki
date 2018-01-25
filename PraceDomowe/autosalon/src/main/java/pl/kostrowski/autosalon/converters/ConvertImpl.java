package pl.kostrowski.autosalon.converters;

import org.springframework.stereotype.Component;
import pl.kostrowski.autosalon.dto.CarDto;
import pl.kostrowski.autosalon.entity.Car;

import java.time.LocalDate;

@Component
public class ConvertImpl implements CarConverter {


    @Override
    public CarDto convert(Car car) {

        Integer id = car.getId();
        String brand = car.getBrand();
        String model = car.getModel();
        LocalDate productionDate = car.getProductionDate();
        String vin = car.getVin();

        CarDto result = new CarDto(id, brand, model, productionDate, vin);

        return result;
    }

    @Override
    public Car convert(CarDto car) {

        Integer id = car.getId();
        String brand = car.getBrand();
        String model = car.getModel();
        LocalDate productionDate = car.getProductionDate();
        String vin = car.getVin();

        Car result = new Car(id, brand, model, productionDate, vin);

        return result;
    }
}
