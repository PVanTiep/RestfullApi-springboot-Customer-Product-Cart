package com.example.Project.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Table(name = "Cart_item")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Cart_item {
    @Id
    @Column(name = "cart_id")
    private long cart_id;

    @Column(name = "product_id",nullable = false)
    private long product_id;

    @Column(name = "quantity_wished",nullable = false)
    private int quantity_wished;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_added", nullable = false)
    private Date date_added;

    @Column(name = "total_amount", nullable = false)
    private BigDecimal total_amount;

//    public Cart_item(long product_id,int quantity_wished, Date date_added,BigDecimal price ){
//        this.product_id=product_id;
//        this.quantity_wished=quantity_wished;
//        this.date_added=date_added;
//        this.total_amount= BigDecimal.valueOf(price.intValue()*quantity_wished);
//    }
//    public Cart_item(long customer_id,long product_id,int quantity_wished, Date date_added,BigDecimal price ){
//        this.product_id=product_id;
//        this.quantity_wished=quantity_wished;
//        this.date_added=date_added;
//        this.total_amount= BigDecimal.valueOf(price.intValue()*quantity_wished);
//    }
//    @ManyToOne
//    @JoinColumn(name = "product_id",nullable = false)
//    private Product product;
//
//    @ManyToOne
//    @JoinColumn(name = "cart_id",nullable = false)
//    private Cart cart;
}
