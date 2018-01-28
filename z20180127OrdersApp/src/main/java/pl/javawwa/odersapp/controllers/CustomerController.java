package pl.javawwa.odersapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.javawwa.odersapp.dto.CustomerDto;
import pl.javawwa.odersapp.services.CustomerService;

import java.util.Map;

@Controller
@RequestMapping("/customers/")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("register")
    public String registerUser(Map<String, Object> model) {

        model.put("customerModel", new CustomerDto());

        return "customers/register";
    }


    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("customerModel") CustomerDto customerDto, Map<String, Object> model) {

        customerService.registerUser(customerDto);
        model.put("userMessage", "Dzięki za zarejestrowanie, aby aktywować konto kliknij w link w mailu który wysłano na adres " + customerDto.getEmail());

        return "message";
    }

    @GetMapping(value = "activate")
    public String activateUser(@RequestParam String login,
                               @RequestParam String token,
                               Map<String, Object> model) {

        Boolean activated = customerService.activateUser(login, token);

        if (activated) {
            model.put("userMessage", "Aktywacja konta o loginie " + login + " powiodła się");
        } else {
            model.put("userMessage", "Aktywacja konta o loginie " + login + " nie powiodła się");
        }

        return "message";
    }


    @GetMapping("login")
    public String loginForm() {
        return "customers/login";
    }


    @GetMapping("loggedIn")
    public String loggedIn(Map<String, Object> model, Authentication authentication) {

        model.put("userMessage", "Użytkownik " + authentication.getName() + " zalogował się poprawnie");

        return "message";
    }

}
