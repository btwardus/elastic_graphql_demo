package com.example.elastic_demo;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @QueryMapping
    Iterable<Product> getProducts() {
        return productRepository.findAll();
    }

    @QueryMapping
    Product getProductById(@Argument String id) {
        return productRepository.findById(id).orElse(null);
    }

    @MutationMapping
    Product createProduct(@Argument ProductInput product ) {
        Product p = new Product(product.id, product.name, product.category, product.price);
        return productRepository.save(p);
    }

    @MutationMapping
    Product updateProduct(@Argument String id, @Argument ProductInput product) {
        Product p = new Product(id, product.name, product.category, product.price);
        return productRepository.save(p);
    }

    @MutationMapping
    Boolean deleteProduct(@Argument String id) {
        productRepository.deleteById(id);
        return true;
    }
    record ProductInput(String id, String name, String category, Double price) {
    }

}