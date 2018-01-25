package pl.kostrowski.autosalon.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.kostrowski.autosalon.entity.Car;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CarRepositoryTest {

    private final Logger LOG = LoggerFactory.getLogger(CarRepositoryTest.class);

    @Autowired
    CarRepository carRepository;

    @Test
    public void shouldFindByBrand() {

        LOG.debug("Starting find by brand repository test");
        assertThat(carRepository.findByBrand("Pontiac"))
                .isNotEmpty()
                .contains(new Car(9,"Pontiac","Firebird",LocalDate.parse("1983-04-21"),"9a184a1e-d7e8-4b28-bcc1-aa8f3ccb0070"));

        assertThat(carRepository.findByBrand("asdas"))
                .isEmpty();

    }


    @Test
    public void shouldFindByModel() {

        LOG.debug("Starting find by model repository test");

        assertThat(carRepository.findByModel("Mustang"))
                .isNotEmpty()
                .contains(new Car(3,"Ford","Mustang",LocalDate.parse("1991-02-17"),"4b6a59ff-f18c-4ccf-b94d-fe25e330e5f0"));

        assertThat(carRepository.findByModel("asdafsd"))
                .isEmpty();
    }


    @Test
    public void shouldFindByProductionDateBetween() {

        LOG.debug("Starting find by production date between repository test");

        LocalDate productionDate = carRepository.findByProductionDateBetween(
                LocalDate.of(1987, 07, 10),
                LocalDate.of(1987, 07, 12)).get(0).getProductionDate();

        assertThat(productionDate.isAfter(LocalDate.of(1987, 07, 10))).isTrue();
        assertThat(productionDate.isBefore(LocalDate.of(1987, 07, 12))).isTrue();

    }


    @Test
    public void shouldFindByVin() {

        LOG.debug("Starting find by vin repository test");

        assertThat(carRepository.findByVin("527b7ecd-2166-4a80-838e-17d71f34b5be").size()).isEqualTo(1);

    }
}