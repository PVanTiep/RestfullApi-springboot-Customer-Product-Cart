package com.example.Project.Model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Customer")
@AllArgsConstructor
@NoArgsConstructor
public class Customer {


    @Id
    @GeneratedValue
    @Column(name = "customer_id")
    private long customer_id;
    @Column(name = "customer_name")
    private String customer_name;
    @Column(name = "address")
    private String address;
    @Column(name = "phone_no")
    private String phone_no;

    @Column(name = "cart_id")
    private long cart_id;

    public Customer(String name, String address, String phone, long idcard) {
        this.customer_name=name;
        this.address=address;
        this.phone_no=phone;
        this.cart_id=idcard;
    }
    public Customer(String name, String address, String phone) {
        this.customer_name=name;
        this.address=address;
        this.phone_no=phone;
    }

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "cart_id", referencedColumnName = "cart_id")
//    private Cart cart;
}
