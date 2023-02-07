package com.example.teacher_project.Service;

import com.example.teacher_project.Exeption.Api;
import com.example.teacher_project.Model.Teacher;
import com.example.teacher_project.Repositry.TeacherRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TeacherService {
    private final TeacherRepositry Teacherepositry;

    public List<Teacher> getTeacher(){
        return Teacherepositry.findAll();
    }

    public void addTeacher(Teacher Teacher){
        Teacherepositry.save(Teacher);
    }

    public void UpdateTeacher(Integer id,Teacher Teacher){
        Teacher m=Teacherepositry.findTeacherById(id);

        if(m==null){
            throw new Api("this id is not here");
        }


    }
    public void deleteTeacher(Integer id) {
        Teacher m = Teacherepositry.findTeacherById(id);

        if (m == null) {
            throw new Api("id not here");

        }

        Teacherepositry.delete(m);

    }

}
