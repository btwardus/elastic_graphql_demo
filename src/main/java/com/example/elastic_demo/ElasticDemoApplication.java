package com.example.elastic_demo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ElasticDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElasticDemoApplication.class, args);
	}

	@Bean
	ApplicationRunner run(ProductRepository productRepository) {
		return args -> {
			productRepository.save(new Product("1", "iPhone 12", "Smartphone", 799.99));
			productRepository.save(new Product("2", "MacBook Pro", "Laptop", 1299.99));
			productRepository.save(new Product("3", "Apple Watch", "Smartwatch", 399.99));
		};
	}
}
