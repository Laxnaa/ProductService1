package com.example.productservice1.Model;

import lombok.Data;

import javax.xml.transform.sax.SAXResult;
@Data
public class Product {
    long id;
    String title;
    double price;
    String description;
    String image;
    Category category;
}
