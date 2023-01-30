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
    public ResponseEntity addUser(@Valid @RequestBody User user, Errors errors){
        if(errors.hasErrors()){
            String massege=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massege);
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body("user added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id,@Valid @RequestBody User user,Errors errors){
        if(errors.hasErrors()){
            String massege=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massege);
        }

        Boolean isUpdated=userService.updateUser(id,user);

        if(isUpdated){
            return ResponseEntity.status(200).body("user updated");
        }
        return ResponseEntity.status(400).body("wrong id");
    }

    @DeleteMapping("/delet/{id}")
    public ResponseEntity deletUser(@PathVariable Integer id){
        boolean isdeleted=userService.deleteUser(id);

        if(isdeleted){
            return ResponseEntity.status(200).body("user deleted");
        }
        return ResponseEntity.status(400).body("wrong id");
    }
}
