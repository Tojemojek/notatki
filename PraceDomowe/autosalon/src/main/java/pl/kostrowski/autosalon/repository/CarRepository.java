package pl.kostrowski.autosalon.repository;

import org.springframework.data.repository.CrudRepository;
import pl.kostrowski.autosalon.entity.Car;

public interface CarRepository extends CrudRepository<Car, Integer> {

}
