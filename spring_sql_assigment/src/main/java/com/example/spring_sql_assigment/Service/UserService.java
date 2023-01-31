package com.example.spring_sql_assigment.Service;

import com.example.spring_sql_assigment.Exeption.Api;
import com.example.spring_sql_assigment.Model.User;
import com.example.spring_sql_assigment.Repositry.UserRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepositry userRepositry;

    public List<User> getUser() {
        return userRepositry.findAll();
    }

    public void addUser(User user) {
        userRepositry.save(user);
    }

    public void updateUser(Integer id, User user) {
        User oldUser = userRepositry.findUserById(id);

        if (oldUser == null) {
            throw new Api("id not here");
        }
        oldUser.setName(user.getName());
        oldUser.setUsername(user.getUsername());
        oldUser.setEmail(user.getEmail());
        oldUser.setPassword(user.getPassword());
        oldUser.setAge(user.getAge());
        oldUser.setRole(user.getRole());
        userRepositry.save(oldUser);

    }

    public void deleteUser(Integer id) {
        User oldUser = userRepositry.findUserById(id);

        if (oldUser == null) {
            throw new Api("id not here");

        }

        userRepositry.delete(oldUser);

    }

    public User findUserByEmail(String email) {
        User user = userRepositry.findUserByEmail(email);
        if (user == null) {
            throw new Api("email is null");
        }
        return user;
    }

    public List<User> findbyage(Integer age) {
        List<User> user = userRepositry.findAllByAgeGreaterThanEqual(age);
        if (user == null) {
            throw new Api("this age is not here");
        }
        return user;
    }

    public List<User> findbyrole(String role){
        List<User> user = userRepositry.findAllByRole(role);
        if (user == null) {
            throw new Api("not here");
        }
        return user;
    }

    public User check(String username,String password){
        User user = userRepositry.findUserByUsernameAndPassword(username,password);
        if (user == null) {
            throw new Api("there is no user with this username and password");
        }
        return user;
    }

}




