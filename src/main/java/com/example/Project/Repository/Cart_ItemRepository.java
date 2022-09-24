package com.example.Project.Repository;

import com.example.Project.Model.Cart_item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Cart_ItemRepository extends JpaRepository<Cart_item,Long> {
}
