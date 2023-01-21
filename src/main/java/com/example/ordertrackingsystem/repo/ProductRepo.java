package com.example.ordertrackingsystem.repo;

import com.example.ordertrackingsystem.modals.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {


}
