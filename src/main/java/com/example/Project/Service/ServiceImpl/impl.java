package com.example.Project.Service.ServiceImpl;

import com.example.Project.Model.Cart;
import com.example.Project.Model.Cart_item;
import com.example.Project.Model.Customer;
import com.example.Project.Model.Product;
import com.example.Project.Repository.*;
import com.example.Project.Service.ServiceProject;
import org.hibernate.jpa.internal.ExceptionMapperLegacyJpaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.*;

@Service
public class impl implements ServiceProject {

    @Autowired
    ProductReporitory productReporitory;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ProductQuery productQuery;

    @Autowired
    Cart_ItemRepository cart_itemRepository;

    @Autowired
    CartItemQuery cartItemQuery;
    @Autowired
    CustomerQuery customerQuery;

    @Autowired
    CartRepository cartRepository;
    @Override
    public Product saveProduct(Product product) {
        return productReporitory.save(product);
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public List<Product> getAllProducts() {
        return productReporitory.findAll();
    }

    @Override
    public List<Product> getByPrice(BigDecimal price, String condition) {
        switch (condition){
            case "LESS_THAN":
                return productQuery.getLessPrice(price);
            case "GREATER_THAN":
                return productQuery.getGreaterPrice(price);
        }
        return productQuery.getEqualPrice(price);
    }

    @Override
    public Cart_item insertCart(long customer_id, long product_id, int quantity) {
        Product product= productQuery.getbyId(product_id);
        Customer customer = customerRepository.getReferenceById(customer_id);
        if (customer.getCart_id()==0) {
            Cart cart = cartRepository.save(new Cart());
            Cart_item cart_item = new Cart_item(cart.getCart_id(),product_id,quantity,new Date(),product.getPrice());
            customerQuery.updateCartID(cart_item.getCart_id(),customer_id);
            return cart_itemRepository.save(cart_item);
        } else {
            Cart_item cart_item = cartItemQuery.getCartItemByIdvsProductID(customer.getCart_id(),product_id);
            if(Objects.isNull(cart_item)){
                Cart_item cart_item1 = new Cart_item(customer.getCart_id(),product_id,quantity,new Date(),product.getPrice());
                customerQuery.updateCartID(cart_item1.getCart_id(),customer_id);
                return cart_itemRepository.save(cart_item1);
            } else {
                    cart_item.setDate_added(new Date());
                    quantity=quantity+cart_item.getQuantity_wished();
                    cart_item.setQuantity_wished(quantity);
                    cart_item.setTotal_amount(BigDecimal.valueOf(product.getPrice().intValue()*quantity));
                    return cart_itemRepository.save(cart_item);
            }
            //Cart_item cart_item = cart_itemRepository.getOne(customer.getCart_id());
//            List<Cart_item> itemList = cart_itemRepository.findAllById(Collections.singleton(customer.getCart_id()));
//            boolean check = false;
//            for (Cart_item item : itemList){
//                if (item.getProduct_id()==product_id){
//                    check=true;
//                    item.setDate_added(new Date());
//                    quantity=quantity+item.getQuantity_wished();
//                    item.setQuantity_wished(quantity);
//                    item.setTotal_amount(BigDecimal.valueOf(product.getPrice().intValue()*quantity));
//                    return cart_itemRepository.save(item);
//                }
//            }
//            if (check==false){
//                Cart_item cart_item = new Cart_item(customer.getCart_id(),product_id,quantity,new Date(),product.getPrice());
//                customerQuery.updateCartID(cart_item.getCart_id(),customer_id);
//                return cart_itemRepository.save(cart_item);
//            }
        }
//        return null;
    }

    @Override
    public List<Product> getAllItemCart(int offset, int limit) {
        return productQuery.getallProduct(offset,limit);
    }


    @PostConstruct
    public void init(){
        customerRepository.save(new Customer("Tiep","21 le van hung","09123192"));
        customerRepository.save(new Customer("Nhung","21 le van hg","093192"));
        customerRepository.save(new Customer("Long","21 le va hung","0923192"));
        customerRepository.save(new Customer("Thien","21 le vang","0913192"));
        customerRepository.save(new Customer("Linh","21  hung","0912312"));

        productReporitory.save(new Product("Ao dai","1","M",200000));
        productReporitory.save(new Product("Ao dai","2","L",250000));
        productReporitory.save(new Product("Ao so mi","1","M",300000));
        productReporitory.save(new Product("Ao so mi","2","L",300000));
        productReporitory.save(new Product("Ao so mi trang","3","M",300000));
        productReporitory.save(new Product("Ao len","1","M",200000));
        productReporitory.save(new Product("Ao du","1","M",200000));
        productReporitory.save(new Product("Ao linh","1","M",200000));
        productReporitory.save(new Product("Ao vai","1","M",200000));
        productReporitory.save(new Product("Ao 3 lo","1","M",200000));
        productReporitory.save(new Product("Ao si da","1","M",200000));
    }

}
