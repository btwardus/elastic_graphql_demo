package com.example.elastic_demo;

import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
public class ProductTests {

    @Test
    public void testProduct() {
        Product product = new Product("1", "iPhone 12", "Smartphone", 799.99);
        assertEquals("1", product.getId());
        assertEquals("iPhone 12", product.getName());
        assertEquals("Smartphone", product.getCategory());
        assertEquals(799.99, product.getPrice());
    }

}