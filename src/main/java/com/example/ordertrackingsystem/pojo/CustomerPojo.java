package com.example.ordertrackingsystem.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class CustomerPojo {

    private Long id;
    private String location;
    private String password;
    private String phoneNumber;
    private String role;
    private String username;


}
