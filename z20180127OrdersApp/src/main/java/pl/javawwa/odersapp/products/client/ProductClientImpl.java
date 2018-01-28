package pl.javawwa.odersapp.products.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class ProductClientImpl implements ProductClient {


    @Value("@{product.server.address}")
    private String producServiceAddress;

    private RestTemplate restTemplate;

    @Autowired
    public ProductClientImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public List<ProductDto> findAll() {

        ResponseEntity<ProductDto[]> responseEntity =
                restTemplate.getForEntity(producServiceAddress + "/products/", ProductDto[].class);

        return CollectionUtils.arrayToList(responseEntity.getBody());
    }

    @Override
    public ProductDto findById(Integer id) {

        ProductDto productDto =
                restTemplate.getForObject(producServiceAddress + "/products/" + id, ProductDto.class);

        return productDto;
    }
}
