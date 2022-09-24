package com.example.Project.Repository;

import com.example.Project.Model.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface ProductQuery {
    @Select("select * from PRODUCT where PRICE =#{price}")
    @Results(value = {@Result(property = "id", column = "product_id"),
            @Result(property = "product_name", column = "product_name"),
            @Result(property = "type", column = "type"),
            @Result(property = "size", column = "size"),
            @Result(property = "price", column = "price")})
    List<Product> getEqualPrice(BigDecimal price);

    @Select("select * from PRODUCT where PRICE >=#{price}")
    @Results(value = {@Result(property = "id", column = "product_id"),
            @Result(property = "product_name", column = "product_name"),
            @Result(property = "type", column = "type"),
            @Result(property = "size", column = "size"),
            @Result(property = "price", column = "price")})
    List<Product> getGreaterPrice(BigDecimal price);

    @Select("select * from PRODUCT where PRICE <=#{price}")
    @Results(value = {@Result(property = "id", column = "product_id"),
            @Result(property = "product_name", column = "product_name"),
            @Result(property = "type", column = "type"),
            @Result(property = "size", column = "size"),
            @Result(property = "price", column = "price")})
    List<Product> getLessPrice(BigDecimal price);

    @Select("select * from PRODUCT where PRODUCT_ID =#{id}")
    Product getbyId(long id);

    //@Select("select p.product_name from CUSTOMER c, PRODUCT p where c.customer_id=#{customer_id} and p.name_product=#{name_product} order by c.customer_id limit #{limit} offset #{offset}")
    @Select("select * from PRODUCT limit #{limit} offset #{offset}  ")
    @Results(value = {@Result(property = "id", column = "product_id"),
            @Result(property = "name_product", column = "name_product")})
    List<Product> getallProduct(int offset, int limit);
}
