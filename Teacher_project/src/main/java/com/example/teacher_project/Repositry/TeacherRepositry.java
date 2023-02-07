package com.example.teacher_project.Repositry;

import com.example.teacher_project.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepositry extends JpaRepository<Teacher,Integer> {

    Teacher findTeacherById(Integer id);


}
