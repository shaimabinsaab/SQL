package com.example.teacher_project.Repositry;

import com.example.teacher_project.Model.TeacherAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherAddressRepositry extends JpaRepository<TeacherAddress,Integer> {
    TeacherAddress findTeacherAddressById(Integer id);
    TeacherAddress findAllById(Integer id);
}
