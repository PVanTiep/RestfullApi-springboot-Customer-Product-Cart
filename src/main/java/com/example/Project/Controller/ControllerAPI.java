package com.example.Project.Controller;

import com.example.Project.Model.Cart_item;
import com.example.Project.Model.Customer;
import com.example.Project.Model.Product;
import com.example.Project.Service.ServiceImpl.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RestController
@RequestMapping(value = "/api")
public class ControllerAPI {

    @Autowired
    impl implService;

    @PostMapping(value = "/customers")
    public Customer storeDepartment(@RequestBody Customer customer){
        return implService.saveCustomer(customer);
    }
    @PostMapping(value = "/products")
    public Product storeProduct(@RequestBody Product product){
        return implService.saveProduct(product);
    }

    @GetMapping(value = "/customers")
    public List<Customer> getAllCustomers(){
        return implService.getAllCustomers();
    }

    @GetMapping(value = "/products")
    public List<Product> getAllProducts(){
        return implService.getAllProducts();
    }

    @GetMapping(value = "/productsbyPrice")
    public ResponseEntity<List<Product>> getPrice(@RequestParam BigDecimal price,@RequestParam(defaultValue = "null") String condition){
        List<Product> productList = implService.getByPrice(price,condition);
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping(value = "/addCartItem")
    public Cart_item storeCartItem(@RequestParam long customer_id,long product_id,@RequestParam int quantiny ){
        return implService.insertCart(customer_id,product_id,quantiny);
    }

    @GetMapping(value = "/getItem")
    public ResponseEntity<List<Product>> getItemCart(@RequestParam int offset, int limit){
        return new ResponseEntity<>(implService.getAllItemCart(offset,limit),HttpStatus.OK);
    }
}
