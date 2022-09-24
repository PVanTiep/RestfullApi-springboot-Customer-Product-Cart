package com.example.Project.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

import java.util.List;

import static org.hibernate.annotations.CascadeType.DELETE;

@Data
@Entity
@Table(name = "Cart")
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue
    @Column(name = "cart_id")
    private long cart_id;
//    @OneToOne(mappedBy = "cart")
//    private Customer customer;
//    @OneToMany(mappedBy = "cart_id")
//    @Cascade(value = DELETE)
//    List<Cart_item> listCart;
}
