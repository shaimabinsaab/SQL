package com.example.relation_dtbs.Repositry;

import com.example.relation_dtbs.Model.CostemorDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CostomerDetailRepsitry extends JpaRepository<CostemorDetail,Integer>  {
    CostemorDetail findCustomerDetailById(Integer id);
}



