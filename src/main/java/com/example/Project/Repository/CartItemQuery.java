package com.example.Project.Repository;

import com.example.Project.Model.Cart_item;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
@Mapper
public interface CartItemQuery {
    @Select("Select * from CART_ITEM where CART_ID =#{id} and PRODUCT_ID=#{idProduct}")
    public Cart_item getCartItemByIdvsProductID(long id, long idProduct);
}
