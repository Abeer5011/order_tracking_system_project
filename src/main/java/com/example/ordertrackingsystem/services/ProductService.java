package com.example.ordertrackingsystem.services;
import com.example.ordertrackingsystem.modals.Product;
import com.example.ordertrackingsystem.repo.ProductRepo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public List<Product> getAllProduct(){

        return productRepo.findAll();
    }
    public void addProduct(Product product){

        productRepo.save(product);
    }

}
