package com.example.relation_dtbs.Controller;

import com.example.relation_dtbs.DTO.CustomerDto;
import com.example.relation_dtbs.Model.Customer;
import com.example.relation_dtbs.Service.CustomerDetailsService;
import com.example.relation_dtbs.Service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;
    private final CustomerDetailsService customerDetailsService;
    @GetMapping("/get")
    public ResponseEntity getCustomer(){
        List<Customer> Customers=customerService.getCustomer();
        return ResponseEntity.status(200).body(Customers);
    }

    @PostMapping("/add")
    public ResponseEntity addCustomer(@Valid @RequestBody Customer Customer){
        customerService.addCustomer(Customer);
        return ResponseEntity.status(200).body("Customer added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateCustomer(@PathVariable Integer id, @Valid @RequestBody Customer Customer) {
        customerService.UpdateCustomer(id, Customer);
        return ResponseEntity.status(200).body("Customer updated");

    }

    @DeleteMapping("/delet/{id}")
    public ResponseEntity deletCustomer(@PathVariable Integer id){
        customerService.deleteCustomer(id);

        return ResponseEntity.status(200).body("Customer deleted");


    }
    @PostMapping("/adddetails")
    public ResponseEntity addDetails(@RequestBody CustomerDto customerDto){
        customerDetailsService.addcustomerDetals(customerDto);
        return ResponseEntity.status(200).body("Customer detail added");


    }
    @PutMapping("/updatedetails")
    public ResponseEntity updateCustomerdetails(@RequestBody CustomerDto customerDto) {
        customerDetailsService.UpdateCustomerDetails(customerDto);
        return ResponseEntity.status(200).body("Customer details updated");

    }
    @DeleteMapping("/deletdetails/{id}")
    public ResponseEntity deletCustomerDetails(@PathVariable Integer id){
        customerDetailsService.deletecustomerDetails(id);

        return ResponseEntity.status(200).body("Customer details deleted");


    }





}
