package pl.javawwa.spring.converters;

import pl.javawwa.spring.dto.ProductDto;
import pl.javawwa.spring.entity.Product;

public interface ProductDtoConverter {
    public ProductDto convert(Product product);
    public Product convert(ProductDto product);
}
