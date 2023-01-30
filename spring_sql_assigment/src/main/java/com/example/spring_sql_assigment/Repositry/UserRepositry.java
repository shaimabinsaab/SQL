package com.example.spring_sql_assigment.Repositry;

import com.example.spring_sql_assigment.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositry extends JpaRepository<User,Integer> {
}
