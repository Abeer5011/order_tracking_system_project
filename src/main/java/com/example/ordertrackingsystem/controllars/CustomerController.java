package com.example.ordertrackingsystem.controllars;

import com.example.ordertrackingsystem.modals.ApiResponse;
import com.example.ordertrackingsystem.pojo.AuthenticationRequest;
import com.example.ordertrackingsystem.pojo.CustomerPojo;
import com.example.ordertrackingsystem.services.CustomerService;
import com.example.ordertrackingsystem.services.MyUserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "*")
public class CustomerController {


    private final AuthenticationManager authenticationManager;
    @Autowired
    private final CustomerService customerService;
    @Autowired
    private final MyUserDetail myUserDetail;


    public CustomerController(AuthenticationManager authenticationManager, CustomerService customerService, MyUserDetail myUserDetail) {
        this.authenticationManager = authenticationManager;
        this.customerService = customerService;
        this.myUserDetail = myUserDetail;
    }


    @GetMapping("/customers")
    public ResponseEntity<?> getAllCus(){
        return ResponseEntity.ok().body(customerService.getAllCustomers());
    }


    @PostMapping("/register")
    public ResponseEntity<?> addUsers(@RequestBody @Valid CustomerPojo customerPojo, Errors errors){

        String hashedPassword= new BCryptPasswordEncoder().encode(customerPojo.getPassword());
        customerPojo.setPassword(hashedPassword);
        customerService.register(customerPojo);
        ApiResponse apiResponse = new ApiResponse("user is added",201);
        if(errors.hasErrors()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors.getFieldError());
        }
        return ResponseEntity.ok().body(apiResponse);
    }
    @PostMapping("/login")
    public ResponseEntity<?> userLogin(){
        return ResponseEntity.status(200).body(new ApiResponse("welcome back User",200));
    }
    @PostMapping("/admin_register")
    public ResponseEntity<?> addAdmin(@RequestBody CustomerPojo customerPojo, Errors errors){
        String hashedPassword= new BCryptPasswordEncoder().encode(customerPojo.getPassword());
        customerPojo.setPassword(hashedPassword);
        customerService.adminRegister(customerPojo);
        ApiResponse apiResponse = new ApiResponse("admin is added",201);
        if(errors.hasErrors()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors.getFieldError());
        }
        return ResponseEntity.ok().body(apiResponse);
    }

    @PostMapping("/admin_login")
    public ResponseEntity<?> adminLogin(@RequestBody AuthenticationRequest request){
authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
myUserDetail.loadUserByUsername(request.getUsername());
        return ResponseEntity.status(200).body(new ApiResponse("welcome back Admin",200));


    }

}
