package com.example.ordertrackingsystem.pojo;

import com.example.ordertrackingsystem.modals.Customer;
import com.example.ordertrackingsystem.modals.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderPojo {

    private Long id;

    private Integer qty;
    private String orderDate;


    private Customer cust;

    private Product prod;
}
