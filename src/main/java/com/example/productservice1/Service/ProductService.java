package com.example.productservice1.Service;

import com.example.productservice.Model.Product;

import java.util.List;

public interface ProductService {
    public Product getById(long id);
    public List<Product> getListOfProducts();
}
