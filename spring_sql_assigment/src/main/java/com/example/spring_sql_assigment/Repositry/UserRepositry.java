package com.example.spring_sql_assigment.Repositry;

import com.example.spring_sql_assigment.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepositry extends JpaRepository<User,Integer> {

    User findUserByEmail (String Email);

    User findUserById (Integer id);

    List<User> findAllByAgeGreaterThanEqual(Integer age);

    List<User>  findAllByRole(String role);

    User findUserByUsernameAndPassword(String username,String password);

}
