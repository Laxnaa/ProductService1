package com.example.productservice1.Controller;

import com.example.productservice.Model.Product;
import com.example.productservice.Service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
// url: http://localhost:8080/products
@RequestMapping("/products")
public class ProductController {
    ProductService productService;
    public ProductController(ProductService productService){
        this.productService = productService;
    }
    @GetMapping("/{id}")
    public Product getById(@PathVariable("id") long id){
        return productService.getById(id);
    }
    @GetMapping()
    public List<Product> getListOfProducts(){
        return productService.getListOfProducts();
    }
}
