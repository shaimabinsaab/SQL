package com.example.movie.Repositry;

import com.example.movie.Module.Director;
import org.springframework.data.jpa.repository.JpaRepository;



public interface DirectoryRepositry extends JpaRepository<Director,Integer> {
    Director findDirectorById(Integer id);
}
