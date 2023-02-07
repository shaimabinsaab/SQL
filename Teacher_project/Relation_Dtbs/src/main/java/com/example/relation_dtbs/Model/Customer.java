package com.example.relation_dtbs.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToOne(cascade =CascadeType.ALL,mappedBy = "customer")
    @PrimaryKeyJoinColumn
    CostemorDetail costemorDetail;


}
