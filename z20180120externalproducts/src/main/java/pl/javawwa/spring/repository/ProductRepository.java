package pl.javawwa.spring.repository;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.javawwa.spring.entity.Product;
import pl.javawwa.spring.entity.ProductType;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>,
        JpaSpecificationExecutor<Product> {

    public List<Product> findAll(Specification<Product> specification);

    public List<Product> findByName(String name);

    public List<Product> findByProductType(ProductType productType);

    public List<Product> findByNameAndProductType(String name, ProductType productType);

}
