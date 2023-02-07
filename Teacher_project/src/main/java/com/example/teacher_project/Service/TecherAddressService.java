package com.example.teacher_project.Service;

import com.example.teacher_project.DTO.AddressDto;
import com.example.teacher_project.Exeption.Api;
import com.example.teacher_project.Model.Teacher;
import com.example.teacher_project.Model.TeacherAddress;
import com.example.teacher_project.Repositry.TeacherAddressRepositry;
import com.example.teacher_project.Repositry.TeacherRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TecherAddressService {
    private final TeacherRepositry teacherRepositry;
    private final TeacherAddressRepositry teacherAddressRepositry;
    public void addaddressDetals(AddressDto addressDto){
        Teacher teacher=teacherRepositry.findTeacherById(addressDto.getTeacher_id());
        if (teacher==null){
            throw new Api("teacher not found");

        }
        TeacherAddress c= new TeacherAddress(null,addressDto.getArea(),addressDto.getStreet(),addressDto.getBuildingNumber(),teacher);
        teacherAddressRepositry.save(c);

    }

    public void UpdateaddressDetails(AddressDto AddressDto){
        TeacherAddress TeacherAddress=teacherAddressRepositry.findTeacherAddressById(AddressDto.getTeacher_id());
        if (TeacherAddress==null){
            throw new Api("teacher not found");
        }
        TeacherAddress.setArea(AddressDto.getArea());
        TeacherAddress.setStreet(AddressDto.getStreet());
        TeacherAddress.setBuildingNumber(AddressDto.getBuildingNumber());
        teacherAddressRepositry.save(TeacherAddress);

    }

    public void deleteaddressDetails(Integer id){
        TeacherAddress TeacherAddress=teacherAddressRepositry.findTeacherAddressById(id);
        if (TeacherAddress==null){
            throw new Api("teacher not found");
        }
        teacherAddressRepositry.delete(TeacherAddress);
    }

    public TeacherAddress getteacherdetails(Integer id,AddressDto addressDto){
        TeacherAddress TeacherAddress=teacherAddressRepositry.findTeacherAddressById(id);
        if (TeacherAddress==null){
            throw new Api("teacher not found");
        }

        return teacherAddressRepositry.findAllById(id);


    }

}

