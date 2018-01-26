package pl.kostrowski.autosalon.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.kostrowski.autosalon.dto.CarDto;
import pl.kostrowski.autosalon.repository.CarRepository;
import pl.kostrowski.autosalon.service.CarService;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Map;

@Controller
public class CarWebController {

    @Autowired
    CarRepository carRepository;

    @Autowired
    CarService carService;

    @RequestMapping("/cars/list")
    public String findAndShowAllCars(Map<String, Object> model) {

        model.put("allCars", carService.findAllCars());
        model.put("nowDate", LocalDate.now());


        return "index";
    }

    @RequestMapping("/cars/new")
    public String AddCar(Map<String, Object> model) {

        model.put("editedCar", new CarDto());
        model.put("newCar", true);
        return "edit";
    }

    @RequestMapping("/cars/edit/{id}")
    public String editCar(Map<String, Object> model, @PathVariable(value = "id") Integer id) {

        model.put("editedCar", carService.findCarById(id));
        model.put("newCar", false);

        return "edit";
    }

    @RequestMapping(value = "/cars/save/", method = RequestMethod.POST)
    public String saveCar(@Valid @ModelAttribute(value = "editedCar") CarDto carDto,
                          BindingResult result,
                          Map<String, Object> model) {

        model.put("editedCar", carDto);

        if (result.hasErrors()) {
            model.put("thereAreErrors", true);
            model.put("newCar", (carDto.getId()) == null ? true : false);
            return "edit";
        }

        carService.saveCar(carDto);

        return "redirect:/cars/list";
    }

    @RequestMapping(value = "/cars/delete/{id}", method = RequestMethod.GET)
    public String deleteCar(@PathVariable(value = "id") Integer id) {

        carService.deleteCar(id);

        return "redirect:/cars/list";
    }

    @RequestMapping(value = "/cars/find/", method = RequestMethod.GET)
    public String selectCorrectFilter(@RequestParam(value = "brand", required = false) String brand,
                                      @RequestParam(value = "model", required = false) String carModel,
                                      @RequestParam(value = "agefrom", required = false) Integer from,
                                      @RequestParam(value = "ageto", required = false) Integer to,
                                      @RequestParam(value = "vin", required = false) String vin,
                                      Map<String, Object> model) {

        
        model.put("allCars", carService.findCorrectFilters(brand, carModel,from, to, vin));
        model.put("nowDate", LocalDate.now());

        return "index";

    }
}
