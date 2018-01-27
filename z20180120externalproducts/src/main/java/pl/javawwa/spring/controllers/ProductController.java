package pl.javawwa.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.javawwa.spring.dto.ProductDto;
import pl.javawwa.spring.services.ProductService;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/")
    public List<ProductDto> findAll(){
        return productService.findAll();
    }

    @RequestMapping(value = "/{id}")
    public ProductDto findAll(@PathVariable(value = "id") Integer id){
        return productService.findById(id);
    }
}
