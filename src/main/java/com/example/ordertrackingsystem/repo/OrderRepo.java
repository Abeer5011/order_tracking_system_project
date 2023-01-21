package com.example.ordertrackingsystem.repo;

import com.example.ordertrackingsystem.modals.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Orders, Long> {

}
