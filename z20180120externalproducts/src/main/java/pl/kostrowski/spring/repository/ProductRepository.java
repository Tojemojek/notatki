package pl.kostrowski.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.kostrowski.spring.entity.Product;
import pl.kostrowski.spring.entity.ProductType;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{

    public List<Product> findByName(String name);

    public List<Product> findByProductType(ProductType productType);

    public List<Product> findByNameAndProductType(String name, ProductType productType);

}
