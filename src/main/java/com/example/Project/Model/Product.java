package com.example.Project.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue
    @Column(name = "product_id",nullable = false)
    private long id;

    @Column(name = "name_product",nullable = false)
    private String name_product;

    @Column(name = "type")
    private String type;

    @Column(name = "size")
    private String size;

    @Column(name = "price", nullable = false)
    private BigDecimal price;


//    @OneToMany(mappedBy = "product_id")
//    @Cascade(value = DELETE)
//    List<Cart_item> listCart;
public Product(String name, String type, String size, int price){
        this.name_product=name;
        this.type=type;
        this.size=size;
        this.price= BigDecimal.valueOf(price);
    }
}
