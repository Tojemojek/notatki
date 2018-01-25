package pl.kostrowski.autosalon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kostrowski.autosalon.converters.CarConverter;
import pl.kostrowski.autosalon.dto.CarDto;
import pl.kostrowski.autosalon.entity.Car;
import pl.kostrowski.autosalon.repository.CarRepository;

import java.util.LinkedList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepository carRepository;

    @Autowired
    CarConverter carConverter;

    @Override
    public List<CarDto> findAllCars() {

        Iterable<Car> all = carRepository.findAll();

        List<CarDto> carDtos = new LinkedList<>();

        for (Car car : all) {
            carDtos.add(carConverter.convert(car));
        }

        return carDtos;
    }


    @Override
    public CarDto findCarById(Integer id) {

        Car foundById = carRepository.findOne(id);

        return carConverter.convert(foundById);
    }

    @Override
    public void saveCar(CarDto carDto) {

        Car car = carConverter.convert(carDto);
        carRepository.save(car);

    }
}
