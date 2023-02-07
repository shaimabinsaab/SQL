package com.example.relation_dtbs.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CustomerDto {
    private Integer customer_id;
    private Integer age;
    private String phone;
    private String gender;

}
