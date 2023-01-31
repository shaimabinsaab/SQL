package com.example.spring_sql_assigment.Controller;

import com.example.spring_sql_assigment.Model.User;
import com.example.spring_sql_assigment.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getUser(){
        List<User> users=userService.getUser();
        return ResponseEntity.status(200).body(users);
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@Valid @RequestBody User user){
        userService.addUser(user);
        return ResponseEntity.status(200).body("user added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id,@Valid @RequestBody User user) {
        userService.updateUser(id, user);
        return ResponseEntity.status(200).body("user updated");

    }

    @DeleteMapping("/delet/{id}")
    public ResponseEntity deletUser(@PathVariable Integer id){
       userService.deleteUser(id);

       return ResponseEntity.status(200).body("user deleted");


    }

    @GetMapping("/byemail/{email}")
    public ResponseEntity getByemail(@PathVariable String email){
        User user=userService.findUserByEmail(email);
        return ResponseEntity.status(200).body(user);
    }

    @GetMapping("/byage/{age}")
    public ResponseEntity getByage(@PathVariable Integer age){
        List<User> user=userService.findbyage(age);
        return ResponseEntity.status(200).body(user);
    }
    @GetMapping("/byrole/{role}")
    public ResponseEntity getByrole(@PathVariable String role){
        List<User> user=userService.findbyrole(role);
        return ResponseEntity.status(200).body(user);
    }

    @GetMapping("/check/{username}/{password}")
    public ResponseEntity getByrole(@PathVariable String username,@PathVariable String password){
        User user=userService.check(username,password);
        return ResponseEntity.status(200).body(user);
    }





}
