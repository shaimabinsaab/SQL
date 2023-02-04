package com.example.movie.Module;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "should be filled")
    @Column(columnDefinition = "varchar(30) not null")
    @Size(min = 2,message = "name must be more than 2 character")
    private String name;
    @NotEmpty(message = "should be filled")
    @Column(columnDefinition = "varchar(30)check ( genre='Drama' or genre='Action' or genre='Comedy')")
    private String genre;
    @NotEmpty(message = "should be filled")
    @Column(columnDefinition = "int check ( rating >=1 and rating<=5)" )
    private Integer rating;
    @NotEmpty(message = "should be filled")
    @Min(value = 60,message = "duration must be more than 60")
    private Integer duration;
    @NotEmpty(message = "should be filled")
    private Integer directorID;
}
