package pl.kostrowski.spring.initializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.kostrowski.spring.entity.Product;
import pl.kostrowski.spring.entity.ProductType;
import pl.kostrowski.spring.repository.ProductRepository;

import javax.annotation.PostConstruct;

@Component
public class ProductInitializer {

    @Autowired
    ProductRepository productRepository;

    @PostConstruct
    public void initializeData() {

        Product prod1 = new Product(1, "Jabko", ProductType.FOOD, 10);
        Product prod2 = new Product(2, "HoraCórka", ProductType.ELECTRONICS, 3);

        productRepository.save(prod1);
        productRepository.save(prod2);

    }

}
