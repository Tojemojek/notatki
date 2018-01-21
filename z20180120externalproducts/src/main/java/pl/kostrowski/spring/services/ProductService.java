package pl.kostrowski.spring.services;

import pl.kostrowski.spring.dto.ProductDto;

import java.util.List;

public interface ProductService {

    public List<ProductDto> findAll();
    public ProductDto findById(Integer id);

}
