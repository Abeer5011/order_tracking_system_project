package com.example.ordertrackingsystem.controllars;
import com.example.ordertrackingsystem.exception.ApiException;
import com.example.ordertrackingsystem.modals.ApiResponse;
import com.example.ordertrackingsystem.modals.Customer;

import com.example.ordertrackingsystem.modals.Product;
import com.example.ordertrackingsystem.repo.CustomerRepo;

import com.example.ordertrackingsystem.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class ProductController {

private Customer customer;
private final ProductService productService;
    @Autowired
    private final CustomerRepo customerRepo;

    public ProductController(ProductService productService, CustomerRepo customerRepo) {
        this.productService = productService;
        this.customerRepo = customerRepo;
    }
@GetMapping("/products")
    public ResponseEntity<?> getProduct(){
        return ResponseEntity.ok().body(productService.getAllProduct());
        }


    @PostMapping("/add_product")
    public ResponseEntity<?> addProduct(@RequestBody Product product){

//        if (customer.getRole().equals("USER")){
//
//            throw  new ApiException("U not an Admin");
//        }
            productService.addProduct(product);
            return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("product is added", 201));



    }
}
