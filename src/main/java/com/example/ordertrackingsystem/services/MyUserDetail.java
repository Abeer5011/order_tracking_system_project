package com.example.ordertrackingsystem.services;
import com.example.ordertrackingsystem.modals.Customer;

import com.example.ordertrackingsystem.repo.CustomerRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetail implements UserDetailsService {

    private final CustomerRepo customerRepo;
    @Autowired
    public MyUserDetail(CustomerRepo userRepo) {
        this.customerRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        return customerRepo.getCustomerByUsername(username)
                .orElseThrow(()->new UsernameNotFoundException("Wrong username or password"));

    }

}
