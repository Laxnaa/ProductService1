package com.example.productservice1.Service;

import com.example.productservice.Dto.FakeStoreProductDTO;
import com.example.productservice.Model.Category;
import com.example.productservice.Model.Product;
import com.example.productservice.Service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Service
public class FakeStoreProductServiceImpl implements ProductService {
    public Product convertToProduct( FakeStoreProductDTO fakeStoreProductDTO){
        Product product = new Product();
        product.setId(fakeStoreProductDTO.getId());
        product.setTitle(fakeStoreProductDTO.getTitle());
        product.setPrice(fakeStoreProductDTO.getPrice());
        product.setImage(fakeStoreProductDTO.getImage());
        Category category = new Category();
        category.setName(fakeStoreProductDTO.getCategory());
        product.setCategory(category);
        return product;
    }
    public Product getById(long id){
        RestTemplate restTemplate = new RestTemplate();
        FakeStoreProductDTO fakeStoreProductDTO = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDTO.class);
        return convertToProduct(fakeStoreProductDTO);
    }
    public List<Product> getListOfProducts(){
        RestTemplate restTemplate = new RestTemplate();
        FakeStoreProductDTO[] fakeStoreProductDTOList = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDTO[].class);
        List<Product> productList = new ArrayList<>();
        for(FakeStoreProductDTO ProductDTO : fakeStoreProductDTOList){
            productList.add(convertToProduct(ProductDTO));
        }
        return productList;
    }

}
