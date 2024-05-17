package com.example.productservice1.Dto;

import lombok.Data;

@Data
public class FakeStoreProductDTO {
    long id;
    String title;
    double price;
    String description;
    String image;
    String category;
}
