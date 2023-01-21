package com.example.ordertrackingsystem.modals;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Set;

@NoArgsConstructor @AllArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Min(value = 0)
    private Integer gtyInStock;
    private String name;
    private String image;
    private String category;

    @JsonIgnore
    @OneToMany(mappedBy = "prod", cascade = CascadeType.ALL)
//    @JsonManagedReference(value = "prod_role")
    private List<Orders> orders;

    public Long getpId() {
        return id;
    }

    public void setpId(Long pId) {
        this.id = id;
    }

    public Integer getGtyInStock() {
        return gtyInStock;
    }

    public void setGtyInStock(Integer gtyInStock) {
        this.gtyInStock = gtyInStock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

}
