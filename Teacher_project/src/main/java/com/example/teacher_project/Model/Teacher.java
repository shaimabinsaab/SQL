package com.example.teacher_project.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "should be filled")
    @Column(columnDefinition = "varchar(30) not null")
    @Size(min = 4,message = "name must be more than 4 character")
    private String name;
    @NotEmpty(message = "should be filled")
    private int age;
    @NotEmpty(message = "should be filled")
    @Column(columnDefinition = "varchar(50) not null")
    @Email
    private String email;
    @NotEmpty(message = "should be filled")
    private int salary;
    @OneToOne(cascade =CascadeType.ALL,mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    TeacherAddress address;
}
