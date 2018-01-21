package pl.kostrowski.spring.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.kostrowski.spring.dto.ProductDto;
import pl.kostrowski.spring.entity.Product;
import pl.kostrowski.spring.services.ProductService;

import java.util.List;
import java.util.Map;

@Controller
public class ProductWebController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/products-web/")
    public ModelAndView findProducts(Map<String, Object> model) {

        List<ProductDto> productDto = productService.findAll();
        model.put("productList", productDto);

        return new ModelAndView("products");
    }


    @RequestMapping(value = "/products-web/{id}")
    public ModelAndView findProduct(Map<String, Object> model, @PathVariable(value = "id") Integer id) {

        ProductDto productDto = productService.findById(id);
        model.put("singleProduct", productDto);

        return new ModelAndView("singleProduct");
    }
}
