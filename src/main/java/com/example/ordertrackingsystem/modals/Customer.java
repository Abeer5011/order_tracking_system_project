package com.example.ordertrackingsystem.modals;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@NoArgsConstructor @Data @AllArgsConstructor
@Entity
public class Customer implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String location;
    private String password;
    @Column(name = "phone_number", unique = true, nullable = false)
    @Min(7)
    private String phoneNumber;
    @Column(unique = true, nullable = false)
    private String username;
    //    //هنا راح يربط او يجيب البيانات من كلاس يدخل الكلاس الاوردر ويدور على الاسم الي حطيته عند العلاقة عشان يقدر يجيب البيانات ويحطها في جدول
    @JsonIgnore
    @OneToMany(mappedBy = "cust", cascade = CascadeType.ALL)
    private List<Orders> orders;

    private String role;



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(this.role));
    }


    public Customer(Long id, String location, String password, String phoneNumber, String role, String username) {
        this.id = id;
       this.username = username;
       this.password = password;
       this.role = role;
       this.phoneNumber = phoneNumber;
        this.location = location;
    }





    @Override
    public String getPassword() {
        return "password";
    }

    public String getUsername() {
         return username;
     }


     @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }




 }
