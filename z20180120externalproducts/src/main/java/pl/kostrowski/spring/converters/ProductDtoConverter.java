package pl.kostrowski.spring.converters;

import pl.kostrowski.spring.dto.ProductDto;
import pl.kostrowski.spring.entity.Product;

public interface ProductDtoConverter {
    public ProductDto convert(Product product);
}
