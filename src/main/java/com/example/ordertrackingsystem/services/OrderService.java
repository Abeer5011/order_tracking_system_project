package com.example.ordertrackingsystem.services;

import com.example.ordertrackingsystem.modals.Customer;
import com.example.ordertrackingsystem.modals.Orders;
import com.example.ordertrackingsystem.modals.Product;
import com.example.ordertrackingsystem.repo.CustomerRepo;
import com.example.ordertrackingsystem.repo.OrderRepo;
import com.example.ordertrackingsystem.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {


    private Customer customer;
    private Product product;

    private DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
    private Date date = new Date();


    @Autowired
    private final ProductRepo productRepo;
    @Autowired
    private final CustomerRepo customerRepo;
    @Autowired
    private final OrderRepo orderRepo;

    public OrderService(ProductRepo productRepo, CustomerRepo customerRepo, OrderRepo orderRepo) {
        this.productRepo = productRepo;
        this.customerRepo = customerRepo;
        this.orderRepo = orderRepo;
    }

    public List<Orders> getAllOrders(){

        return orderRepo.findAll();
    }

    public Orders newOrder(Orders orders, Long custId, Long prodId){

       customer = customerRepo.findById(custId).get();
        product = productRepo.findById(prodId).get();
        System.out.println(customer +"-----------"+ product);
        orders.addProduct(product, customer);
        product.setGtyInStock(product.getGtyInStock() - orders.getQty());
      orders.setOrderDate(dateFormat.format(date));
      orders.getCust().setUsername(customer.getUsername());
        System.out.println(customer +"-----------"+ product);
 return orderRepo.save(orders);
    }
}
