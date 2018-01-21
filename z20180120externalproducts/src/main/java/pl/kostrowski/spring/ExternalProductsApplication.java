package pl.kostrowski.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
public class ExternalProductsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExternalProductsApplication.class, args);
	}
}
