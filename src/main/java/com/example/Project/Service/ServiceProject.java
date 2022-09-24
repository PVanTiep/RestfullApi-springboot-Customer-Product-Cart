package com.example.Project.Service;

import com.example.Project.Model.Cart_item;
import com.example.Project.Model.Customer;
import com.example.Project.Model.Product;
import com.example.Project.Repository.CustomerRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ServiceProject  {
    Product saveProduct(Product product);
    Customer saveCustomer(Customer customer);
    List<Customer> getAllCustomers();
    List<Product> getAllProducts();
    List<Product> getByPrice(BigDecimal price, String condition);

    Cart_item insertCart(long customer_id, long product_id, int quantity );

    List<Product> getAllItemCart(int offset, int limit);
}
