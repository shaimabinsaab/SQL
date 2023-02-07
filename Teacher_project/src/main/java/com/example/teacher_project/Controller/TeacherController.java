package com.example.teacher_project.Controller;

import com.example.teacher_project.DTO.AddressDto;
import com.example.teacher_project.Model.Teacher;
import com.example.teacher_project.Model.TeacherAddress;
import com.example.teacher_project.Service.TeacherService;
import com.example.teacher_project.Service.TecherAddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/teacher")
public class TeacherController {
    private final TeacherService teacherService;
    private final TecherAddressService techerAddressService;
    @GetMapping("/get")
    public ResponseEntity getTeacher(){
        List<Teacher> teachers=teacherService.getTeacher();
        return ResponseEntity.status(200).body(teachers);
    }

    @PostMapping("/add")
    public ResponseEntity addTeacher(@Valid @RequestBody Teacher teachers){
        teacherService.addTeacher(teachers);
        return ResponseEntity.status(200).body("Teacher added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable Integer id, @Valid @RequestBody Teacher teachers) {
        teacherService.UpdateTeacher(id, teachers);
        return ResponseEntity.status(200).body("Teacher updated");

    }

    @DeleteMapping("/delet/{id}")
    public ResponseEntity deletTeacher(@PathVariable Integer id){
        teacherService.deleteTeacher(id);

        return ResponseEntity.status(200).body("Teacher deleted");


    }
    @PostMapping("/adddetails")
    public ResponseEntity addDetails(@RequestBody AddressDto addressDto){
        techerAddressService.addaddressDetals(addressDto);
        return ResponseEntity.status(200).body("Teacher detail added");


    }
    @PutMapping("/updatedetails")
    public ResponseEntity updateTeacherdetails(@RequestBody AddressDto addressDto) {
        techerAddressService.UpdateaddressDetails(addressDto);
        return ResponseEntity.status(200).body("Teacher details updated");

    }
    @DeleteMapping("/deletdetails/{id}")
    public ResponseEntity deletTeacherDetails(@PathVariable Integer id){
        techerAddressService.deleteaddressDetails(id);

        return ResponseEntity.status(200).body("Teacher details deleted");


    }
    @GetMapping("/getdetails/{id}")
    public ResponseEntity getTeacherdetails(@PathVariable Integer id,@RequestBody AddressDto addressDto){
       TeacherAddress teachers=techerAddressService.getteacherdetails(id,addressDto);
        return ResponseEntity.status(200).body(teachers);
    }


}
