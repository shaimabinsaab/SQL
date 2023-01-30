package com.example.spring_sql_assigment.Service;

import com.example.spring_sql_assigment.Model.User;
import com.example.spring_sql_assigment.Repositry.UserRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepositry userRepositry;

    public List<User> getUser(){
        return userRepositry.findAll();
    }
    public void addUser(User user){
        userRepositry.save(user);
    }
    public Boolean updateUser(Integer id,User user){
        User oldUser=userRepositry.getById(id);

        if(oldUser==null){
            return false;
        }
        oldUser.setName(user.getName());
        oldUser.setUsername(user.getUsername());
        oldUser.setEmail(user.getEmail());
        oldUser.setPassword(user.getPassword());
        oldUser.setAge(user.getAge());
        oldUser.setRole(user.getRole());
        userRepositry.save(oldUser);
        return true;
    }
    public Boolean deleteUser(Integer id){
        User oldUser=userRepositry.getById(id);

        if(oldUser==null){
            return false;
        }

        userRepositry.delete(oldUser);
        return true;
    }

}
