package com.example.relation_dtbs.Service;

import com.example.relation_dtbs.Exeption.Api;
import com.example.relation_dtbs.Model.Customer;
import com.example.relation_dtbs.Repositry.CustomerRepostry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepostry Customerepositry;

    public List<Customer> getCustomer(){
        return Customerepositry.findAll();
    }

    public void addCustomer(Customer Customer){
        Customerepositry.save(Customer);
    }

    public void UpdateCustomer(Integer id,Customer Customer){
        Customer m=Customerepositry.findCustomerById(id);

        if(m==null){
            throw new Api("this id is not here");
        }


    }
    public void deleteCustomer(Integer id) {
        Customer m = Customerepositry.findCustomerById(id);

        if (m == null) {
            throw new Api("id not here");

        }

        Customerepositry.delete(m);

    }
    
}
