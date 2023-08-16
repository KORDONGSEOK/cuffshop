package dev.cuffshop;

import dev.cuffshop.repository.product.ProductRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class CuffshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(CuffshopApplication.class, args);
	}


	@Bean
	@Profile("local")
	public TestDataInit testDataInit(ProductRepository productRepository) {
		return new TestDataInit(productRepository);
	}


}
