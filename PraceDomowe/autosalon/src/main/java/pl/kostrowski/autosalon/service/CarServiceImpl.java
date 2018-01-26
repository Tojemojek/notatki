package pl.kostrowski.autosalon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kostrowski.autosalon.converters.CarConverter;
import pl.kostrowski.autosalon.dto.CarDto;
import pl.kostrowski.autosalon.entity.Car;
import pl.kostrowski.autosalon.repository.CarRepository;

import java.time.LocalDate;
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


    @Override
    public void deleteCar(Integer id) {

        carRepository.delete(id);

    }

    @Override
    public List<CarDto> findCarBetweenAge(Integer from, Integer to) {

        if (from == null){
            from = 0;
        }

        if (to == null){
            to = 9999;
        }

        LocalDate fromDate = LocalDate.now().minusYears(from);
        LocalDate toDate = LocalDate.now().minusYears(to);

        List<Car> byProductionDateBetween = carRepository.findByProductionDateBetween(toDate, fromDate);

        List<CarDto> result = new LinkedList<>();

        if (!byProductionDateBetween.isEmpty()) {

            for (Car car : byProductionDateBetween) {
                result.add(carConverter.convert(car));
            }
        }
        return result;
    }

    @Override
    public List<CarDto> findCorrectFilters(String brand, String carModel, Integer from, Integer to, String vin) {

        List<CarDto> result = new LinkedList<>();

        List<Car> byBrand = carRepository.findByBrand(brand);
        List<Car> byModel = carRepository.findByModel(carModel);
        List<Car> byVin = carRepository.findByVin(vin);

        if (from != null || to != null) {
            List<CarDto> carBetweenAge = this.findCarBetweenAge(from, to);
            result.addAll(carBetweenAge);
        }

        for (Car car : byBrand) {
            result.add(carConverter.convert(car));
        }

        for (Car car : byModel) {
            result.add(carConverter.convert(car));
        }

        for (Car car : byVin) {
            result.add(carConverter.convert(car));
        }

        return result;
    }
}
