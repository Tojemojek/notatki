package pl.kostrowski.autosalon.converters;

import org.springframework.stereotype.Component;
import pl.kostrowski.autosalon.dto.CarDto;
import pl.kostrowski.autosalon.entity.Car;

@Component
public interface CarConverter {

    CarDto convert(Car car);
    Car convert(CarDto car);

}
