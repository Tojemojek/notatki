package pl.kostrowski.spring.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.kostrowski.spring.dto.ProductDto;
import pl.kostrowski.spring.entity.ProductType;
import pl.kostrowski.spring.exceptions.ProductNameExists;
import pl.kostrowski.spring.services.ProductService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Controller
public class ProductWebController {

    @Autowired
    private ProductService productService;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/products-web/list")
    public String findProducts(@RequestParam(value = "productName", required = false) String productName,
                               @RequestParam(value = "productType", required = false) String productType,
                               Map<String, Object> model) {

        List<ProductDto> productDto = productService.findAllByName(productName, productType);
        model.put("productList", productDto);

        return "products";
    }

    @RequestMapping(value = "/products-web/edit/{id}")
    public String findAndEditProduct(Map<String, Object> model, @PathVariable(value = "id") Integer id) {

        ProductDto productDto = productService.findById(id);

        Map<String, String> productsTypes = getAllProductTypesAsMap();

        model.put("singleProduct", productDto);
        model.put("productTypes", productsTypes);
        model.put("edit", Boolean.TRUE);

        return "singleProductEdit";
    }

    @RequestMapping(value = "/products-web/new")
    public String addProduct(Map<String, Object> model) {

        Map<String, String> productsTypes = getAllProductTypesAsMap();

        model.put("singleProduct", new ProductDto());
        model.put("productTypes", productsTypes);
        model.put("edit", Boolean.FALSE);
        return "singleProductEdit";
    }

    @RequestMapping(value = "/products-web/save", method = RequestMethod.POST)
    public String saveProduct(@Valid @ModelAttribute(value = "singleProduct") ProductDto productDto,
                              BindingResult result,
                              Map<String, Object> model) {

        model.put("productTypes", getAllProductTypesAsMap());
        model.put("singleProduct", productDto);

        if (result.hasErrors()) {
            return "singleProductEdit";
        }
        try {
            productService.save(productDto);
        } catch (ProductNameExists e) {
            model.put("errorMessage",
                    messageSource.getMessage("singleProduct.nameExists",
                            new String[]{productDto.getName()},
                            Locale.getDefault()));
            return "singleProductEdit";
        }
        return "redirect:/products-web/list";
    }

    //to nie jest zbyt poprawne
    //działa ale powinno być mapowianie metody delete
    //co nie da się za zrobić gołym a href
    @RequestMapping(value = "/products-web/delete/{id}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable(value = "id") Integer id) {

        productService.delete(id);

        return "redirect:/products-web/list";
    }

    private Map<String, String> getAllProductTypesAsMap() {
        Map<String, String> productsTypes = new HashMap<>();

        for (ProductType productType : ProductType.values()) {
            productsTypes.put(productType.name(), productType.getValue());
        }
        return productsTypes;
    }
}
