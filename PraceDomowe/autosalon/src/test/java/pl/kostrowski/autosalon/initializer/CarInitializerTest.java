package pl.kostrowski.autosalon.initializer;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.kostrowski.autosalon.entity.Car;
import pl.kostrowski.autosalon.repository.CarRepository;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarInitializerTest {

    @Autowired
    CarRepository carRepository;

    @Test
    public void shouldFillDatabaseWithRandomCarsData() {

        List<Car> allCars = (List<Car>) carRepository.findAll();

        Assert.assertEquals(1000, allCars.size());

    }
}