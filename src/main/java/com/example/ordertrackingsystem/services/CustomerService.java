package com.example.ordertrackingsystem.services;

import com.example.ordertrackingsystem.modals.Customer;
import com.example.ordertrackingsystem.pojo.CustomerPojo;
import com.example.ordertrackingsystem.repo.CustomerRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {


    private final CustomerRepo customerRepo;
    private Customer customer;

    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public List<Customer> getAllCustomers(){

        return customerRepo.findAll();
    }


    public void register(CustomerPojo customerPojo){
        customer = new Customer(
                customerPojo.getId(),
                customerPojo.getLocation(),
                customerPojo.getPassword(),
                customerPojo.getPhoneNumber(),
                customerPojo.getRole(),
                customerPojo.getUsername());
        customer.setRole("USER");
        customerRepo.save(customer);
    }

    public void adminRegister(CustomerPojo customerPojo){
         customer = new Customer(
                customerPojo.getId(),
                 customerPojo.getLocation(),
                 customerPojo.getPassword(),
                 customerPojo.getPhoneNumber(),
                 customerPojo.getRole(),
                 customerPojo.getUsername()
                 );
        customer.setRole("ADMIN");
        customerRepo.save(customer);
    }



}
