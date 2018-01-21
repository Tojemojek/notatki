package pl.kostrowski.spring.converters;

import org.springframework.stereotype.Component;
import pl.kostrowski.spring.dto.ProductDto;
import pl.kostrowski.spring.entity.Product;


@Component
public class ProductDtoConverterImpl implements ProductDtoConverter {

    @Override
    public ProductDto convert(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setProductType(product.getProductType().name());
        productDto.setQuantity(product.getQuantity());
        return productDto;
    }

}
