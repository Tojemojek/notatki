package pl.kostrowski.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kostrowski.spring.converters.ProductDtoConverter;
import pl.kostrowski.spring.dto.ProductDto;
import pl.kostrowski.spring.repository.ProductRepository;

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
    public ProductDto findById(Integer id) {
        return productDtoConverter.convert(productRepository.findOne(id));
    }

}
