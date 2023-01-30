package com.example.spring_sql_assigment.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Internal;
import org.springframework.format.annotation.NumberFormat;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "should be filled")
    @Column(columnDefinition = "varchar(30) not null")
    @Size(min = 4,message = "name must be more than 4 character")
    private String name;
    @NotEmpty(message = "should be filled")
    @Column(columnDefinition = "varchar(30) not null unique")
    @Size(min = 4,message = "username must be more than 4 character")
    private String username;
    @Column(columnDefinition = "varchar(30) not null")
    private String password;
    @Email
    @Column(columnDefinition = "varchar(30) not null unique")
    private String email;
    @NotEmpty(message = "should be filled")
    @Column(columnDefinition = "varchar(30)check ( role='user' or role='admin')")
    private String role;
    @NotNull(message = "should be filled")
    @Column(columnDefinition = "int default 0 not null ")
    private Integer age;

}
