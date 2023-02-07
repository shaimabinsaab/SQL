package com.example.teacher_project.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TeacherAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "area should be filled")
    private String area;
    @NotEmpty(message = "street should be filled")
    private String street;
    @NotEmpty(message = "buildingNumber should be filled")
    private int buildingNumber;
    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;

}
