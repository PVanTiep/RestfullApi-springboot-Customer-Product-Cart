package com.example.Project.Repository;

import com.example.Project.Model.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CustomerRepository extends JpaRepository<Customer,Long > {
}
