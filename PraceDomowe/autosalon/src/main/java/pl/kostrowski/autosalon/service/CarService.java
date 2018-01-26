package pl.kostrowski.autosalon.service;

import pl.kostrowski.autosalon.dto.CarDto;

import java.util.List;

public interface CarService {

    public List<CarDto> findAllCars();

    public CarDto findCarById(Integer id);

    public void saveCar(CarDto carDto);

    public void deleteCar(Integer id);

    public List<CarDto> findCarBetweenAge(Integer from, Integer to);

    public List<CarDto> findCorrectFilters(String brand, String carModel, Integer from, Integer to, String vin);

}
