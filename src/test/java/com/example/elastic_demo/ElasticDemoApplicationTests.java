package com.example.elastic_demo;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ElasticDemoApplicationTests {

	@Test
	void contextLoads() {
	}


	@Test
	void testControllerCreateProduct() {
		// Mock the repository
		ProductRepository productRepository = Mockito.mock(ProductRepository.class);

		// Create the controller with the mocked repository
		ProductController productController = new ProductController(productRepository);

		// Input for the controller method
		ProductController.ProductInput productInput = new ProductController.ProductInput("1", "iPhone 12", "Smartphone", 799.99);

		// Mock the behavior of the repository to return a new Product when save is called
		Mockito.when(productRepository.save(Mockito.any(Product.class))).thenAnswer(invocation -> invocation.getArgument(0));

		// Call the controller method
		Product product = productController.createProduct(productInput);

		// Assert that the returned product has the expected fields
		assertEquals("1", product.getId());
		assertEquals("iPhone 12", product.getName());
		assertEquals("Smartphone", product.getCategory());
		assertEquals(799.99, product.getPrice(), 0.001); // Using a delta for floating-point comparison
	}

	@Test
	void testControllerGetProducts() {
		// Mock the repository
		ProductRepository productRepository = Mockito.mock(ProductRepository.class);

		// Create the controller with the mocked repository
		ProductController productController = new ProductController(productRepository);

		// Mock the behavior of the repository to return a list of products when findAll is called
		Mockito.when(productRepository.findAll()).thenReturn(
				java.util.Arrays.asList(
						new Product("1", "iPhone 12", "Smartphone", 799.99),
						new Product("2", "MacBook Pro", "Laptop", 1299.99),
						new Product("3", "Apple Watch", "Smartwatch", 399.99)
				)
		);

		// Call the controller method
		Iterable<Product> products = productController.getProducts();

		// Assert that the returned products have the expected size and contents
		java.util.List<Product> productList = java.util.stream.StreamSupport.stream(products.spliterator(), false)
				.toList();
		assertEquals(3, productList.size());
		assertEquals("1", productList.getFirst().getId());
		assertEquals("iPhone 12", productList.getFirst().getName());
		assertEquals("Smartphone", productList.getFirst().getCategory());
		assertEquals(799.99, productList.getFirst().getPrice(), 0.001); // Using a delta for floating-point comparison
		assertEquals("2", productList.get(1).getId());
		assertEquals("MacBook Pro", productList.get(1).getName());
		assertEquals("Laptop", productList.get(1).getCategory());
		assertEquals(1299.99, productList.get(1).getPrice(), 0.001); // Using a delta for floating-point comparison
		assertEquals("3", productList.get(2).getId());
		assertEquals("Apple Watch", productList.get(2).getName());
		assertEquals("Smartwatch", productList.get(2).getCategory());
		assertEquals(399.99, productList.get(2).getPrice(), 0.001); // Using a delta for floating-point comparison

	}


	@Test
	void testControllerDeleteProduct() {
		// Mock the repository
		ProductRepository productRepository = Mockito.mock(ProductRepository.class);

		// Create the controller with the mocked repository
		ProductController productController = new ProductController(productRepository);

		// Mock the behavior of the repository to return a list of products when findAll is called
		Mockito.when(productRepository.findAll()).thenReturn(
				java.util.Arrays.asList(
						new Product("1", "iPhone 12", "Smartphone", 799.99),
						new Product("2", "MacBook Pro", "Laptop", 1299.99),
						new Product("3", "Apple Watch", "Smartwatch", 399.99)
				)
		);

		// Call the controller method
		Boolean result = productController.deleteProduct("1");

		// Assert that the returned products have the expected size and contents
		assertEquals(true, result);
	}


	@Test
	void testControllerUpdateProduct() {
		// Mock the repository
		ProductRepository productRepository = Mockito.mock(ProductRepository.class);

		// Create the controller with the mocked repository
		ProductController productController = new ProductController(productRepository);

		// Input for the controller method
		ProductController.ProductInput productInput = new ProductController.ProductInput("1", "iPhone 12", "Smartphone", 799.99);

		// Mock the behavior of the repository to return a new Product when save is called
		Mockito.when(productRepository.save(Mockito.any(Product.class))).thenAnswer(invocation -> invocation.getArgument(0));

		// Call the controller method
		Product product = productController.updateProduct("1", productInput);

		// Assert that the returned product has the expected fields
		assertEquals("1", product.getId());
		assertEquals("iPhone 12", product.getName());
		assertEquals("Smartphone", product.getCategory());
		assertEquals(799.99, product.getPrice(), 0.001); // Using a delta for floating-point comparison
	}
}
