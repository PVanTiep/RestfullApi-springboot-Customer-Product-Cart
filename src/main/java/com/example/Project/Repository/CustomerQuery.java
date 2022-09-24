package com.example.Project.Repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface CustomerQuery {
    @Update("update CUSTOMER set CART_ID=#{card_id} where CUSTOMER_ID=#{customer_id}")
    public void updateCartID(long card_id, long customer_id);
}
