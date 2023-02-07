package com.example.relation_dtbs.Repositry;

import com.example.relation_dtbs.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepostry extends JpaRepository<Customer,Integer> {
    Customer findCustomerById(Integer id);

}
