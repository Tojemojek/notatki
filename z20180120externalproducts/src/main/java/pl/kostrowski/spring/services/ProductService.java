package pl.kostrowski.spring.services;

import pl.kostrowski.spring.dto.ProductDto;
import pl.kostrowski.spring.exceptions.ProductNameExists;

import java.util.List;

public interface ProductService {

    public List<ProductDto> findAll();

    public ProductDto findById(Integer id);

    public void save(ProductDto productDto) throws ProductNameExists;

    public void delete(Integer id);

    public List<ProductDto> findByName(String name);

    public List<ProductDto> findByType(String type);

    public List<ProductDto> findByNameAndType(String name, String type);

}
