package com.example.ordertrackingsystem.controllars;
import com.example.ordertrackingsystem.modals.ApiResponse;
import com.example.ordertrackingsystem.modals.Orders;
import com.example.ordertrackingsystem.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {


    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok().body(orderService.getAllOrders());
    }

    @PutMapping("/addOrder/{prodId}/order/{custId}")
    public ResponseEntity<?> addO(@RequestBody @Valid Orders orders, @PathVariable Long custId, @PathVariable Long prodId){

        orderService.newOrder(orders, custId,prodId);
        return ResponseEntity.ok().body(new ApiResponse("order Created", 201));
    }
}
