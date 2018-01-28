package pl.javawwa.odersapp.products.client;

import java.util.List;

public interface ProductClient {

    public List<ProductDto> findAll();
    public ProductDto findById(Integer id);

}
