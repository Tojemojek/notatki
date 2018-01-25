package pl.kostrowski.autosalon.repository;

import org.springframework.data.repository.CrudRepository;
import pl.kostrowski.autosalon.entity.Car;

import java.time.LocalDate;
import java.util.List;

public interface CarRepository extends CrudRepository<Car, Integer> {

    List<Car> findByBrand(String brand);
    List<Car> findByModel(String model);
    List<Car> findByProductionDateBetween(LocalDate from, LocalDate until);
    List<Car> findByVin(String vin);

}
