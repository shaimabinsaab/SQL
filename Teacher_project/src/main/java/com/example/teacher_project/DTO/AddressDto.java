package com.example.teacher_project.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AddressDto {
    private Integer teacher_id;
    private String area;
    private String street;
    private int buildingNumber;
}
