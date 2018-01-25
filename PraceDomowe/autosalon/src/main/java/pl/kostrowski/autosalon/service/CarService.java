package pl.kostrowski.autosalon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kostrowski.autosalon.dto.CarDto;
import pl.kostrowski.autosalon.repository.CarRepository;

import java.util.LinkedList;
import java.util.List;

public interface CarService {

    public List<CarDto> findAllCars();
    public CarDto findCarById(Integer id);
    public void saveCar(CarDto carDto);


}
