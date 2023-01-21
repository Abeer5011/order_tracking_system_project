package com.example.ordertrackingsystem.modals;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.Min;


@NoArgsConstructor
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Min(1)
    private Integer qty;
    private String orderDate;

    @ManyToOne
    @JoinColumn(name="custId", referencedColumnName = "id")
    private Customer cust;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="pId", referencedColumnName = "id")
    private Product prod;

    public Orders(Long id, Integer qty, String orderDate, Customer cust, Product prod) {
        this.id = id;
        this.qty = qty;
        this.orderDate = orderDate;
        this.cust = cust;
        this.prod = prod;
    }

    public void addProduct(Product product, Customer customer) {
        this.prod = product;
        this.cust = customer;
    }

    public Long getId() {
        return id;
    }

    public Integer getQty() {
        return qty;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public Customer getCust() {
        return cust;
    }

    public Product getProd() {
        return prod;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public void setCust(Customer cust) {
        this.cust = cust;
    }

    public void setProd(Product prod) {
        this.prod = prod;
    }



}
