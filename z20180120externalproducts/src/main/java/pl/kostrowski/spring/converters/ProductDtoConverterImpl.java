package pl.kostrowski.spring.converters;

import org.springframework.stereotype.Component;
import pl.kostrowski.spring.dto.ProductDto;
import pl.kostrowski.spring.entity.Product;
import pl.kostrowski.spring.entity.ProductType;


@Component
public class ProductDtoConverterImpl implements ProductDtoConverter {

    @Override
    public ProductDto convert(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setProductType(product.getProductType().getValue());
        productDto.setQuantity(product.getQuantity());
        return productDto;
    }

    @Override
    public Product convert(ProductDto productDto) {

        Integer id = productDto.getId();
        String name = productDto.getName();
        ProductType productType = ProductType.valueOf(productDto.getProductType());
        Integer quantity = productDto.getQuantity();

        Product product = new Product(id, name, productType, quantity);

        return product;
    }

}
