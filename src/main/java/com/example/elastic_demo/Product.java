package com.example.elastic_demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

//Create a product entity class as a document for elastic search

@Document(indexName = "products")
@AllArgsConstructor
@Data
public class Product {

    @Id
    private String id;

    @Field(name = "name", type = FieldType.Text)
    private String name;
    @Field(name = "category", type = FieldType.Keyword)
    private String category;
    @Field(name = "price", type = FieldType.Double)
    private double price;


}
