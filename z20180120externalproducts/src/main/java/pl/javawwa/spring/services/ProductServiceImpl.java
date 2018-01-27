package pl.javawwa.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import pl.javawwa.spring.converters.ProductDtoConverter;
import pl.javawwa.spring.dto.ProductDto;
import pl.javawwa.spring.entity.Product;
import pl.javawwa.spring.entity.ProductType;
import pl.javawwa.spring.exceptions.ProductNameExists;
import pl.javawwa.spring.repository.ProductRepository;
import pl.javawwa.spring.repository.specification.ProductSpecification;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductDtoConverter productDtoConverter;

    @Override
    public List<ProductDto> findAll() {
        List<ProductDto> convertedProducts =
                StreamSupport.stream(productRepository.findAll().spliterator(), false)
                        .map(p -> productDtoConverter.convert(p))
                        .collect(Collectors.toList());
        return convertedProducts;
    }

    @Override
    public List<ProductDto> findByNameAndType(String name, String type) {

        ProductType productType = null;
        if (type != null) {
            try {
                productType = ProductType.valueOf(type);
            } catch (IllegalArgumentException e) {
                productType = null;
            }
        }

        Product filterProduct = new Product();
        filterProduct.setName(name);
        filterProduct.setProductType(productType);

        List<ProductDto> convertedProducts =
                StreamSupport.stream(
                        productRepository.findAll(new ProductSpecification(filterProduct))
                                .spliterator(), false)
                        .map(p -> productDtoConverter.convert(p))
                        .collect(Collectors.toList());
        return convertedProducts;
    }

    @Override
    public List<ProductDto> findByType(String type) {

        ProductType productType = null;
        if (type != null) {
            productType = ProductType.valueOf(type);
        }
        List<ProductDto> convertedProducts =
                StreamSupport.stream(productRepository.findByProductType(productType).spliterator(), false)
                        .map(p -> productDtoConverter.convert(p))
                        .collect(Collectors.toList());
        return convertedProducts;
    }

    @Override
    public List<ProductDto> findByName(String name) {
        List<ProductDto> convertedProducts =
                StreamSupport.stream(productRepository.findByName(name).spliterator(), false)
                        .map(p -> productDtoConverter.convert(p))
                        .collect(Collectors.toList());
        return convertedProducts;
    }

    @Override
    public ProductDto findById(Integer id) {
        return productDtoConverter.convert(productRepository.findOne(id));
    }

    @Override
    public void save(ProductDto productDto) throws ProductNameExists {
        Product converted = productDtoConverter.convert(productDto);
        List<ProductDto> productsByName = this.findByName(productDto.getName());
        if (!CollectionUtils.isEmpty(productsByName)) {
            throw new ProductNameExists("Product with name " + productDto.getName() + " exists");
        } else {
            productRepository.save(converted);
        }
    }

    @Override
    public void delete(Integer id) {
        productRepository.delete(id);
    }
}
