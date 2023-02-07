package com.example.relation_dtbs.Service;

import com.example.relation_dtbs.DTO.CustomerDto;
import com.example.relation_dtbs.Exeption.Api;
import com.example.relation_dtbs.Model.CostemorDetail;
import com.example.relation_dtbs.Model.Customer;
import com.example.relation_dtbs.Repositry.CostomerDetailRepsitry;
import com.example.relation_dtbs.Repositry.CustomerRepostry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomerDetailsService {
    private final CustomerRepostry customerRepostry;
    private final CostomerDetailRepsitry costomerDetailsRepsitry;

    public void addcustomerDetals(CustomerDto customerDto){
        Customer customer=customerRepostry.findCustomerById(customerDto.getCustomer_id());
        if (customer==null){
            throw new Api("customer not found");

        }
         CostemorDetail c= new CostemorDetail(null,customerDto.getAge(),customerDto.getPhone(),customerDto.getGender(),customer);
        costomerDetailsRepsitry.save(c);

    }

    public void UpdateCustomerDetails(CustomerDto customerDto){
        CostemorDetail costemorDetail=costomerDetailsRepsitry.findCustomerDetailById(customerDto.getCustomer_id());
        if (costemorDetail==null){
            throw new Api("customer not found");
        }
        costemorDetail.setAge(customerDto.getAge());
        costemorDetail.setGender(customerDto.getGender());
        costemorDetail.setPhone(customerDto.getPhone());
        costomerDetailsRepsitry.save(costemorDetail);

    }

    public void deletecustomerDetails(Integer id){
        CostemorDetail costemorDetail=costomerDetailsRepsitry.findCustomerDetailById(id);
        if (costemorDetail==null){
            throw new Api("customer not found");
        }
        costomerDetailsRepsitry.delete(costemorDetail);
    }




}
