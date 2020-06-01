package group3.com.example.retail;


import java.sql.Timestamp;

import org.springframework.boot.CommandLineRunner;




import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import group3.com.example.retail.cart.*;
import group3.com.example.retail.product.ProductRepository;


@SpringBootApplication
public class RetailApplication {

	//private static final Logger log = LoggerFactory.getLogger(RetailApplication.class);

	@Bean
	public CommandLineRunner demoCart(CartRepository cartRepo, ProductRepository productRepo) {
		return (args) -> {
			// Get all Carts
			cartRepo.findAll().forEach((cart) -> { System.out.println(cart.toString()); });

			// Add item to a Cart
		};
	}

	
	public static void main(String[] args) {
		SpringApplication.run(RetailApplication.class, args);
	}
}




