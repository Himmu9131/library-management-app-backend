package com.demo.example.student_library_management_system.converters;

import com.demo.example.student_library_management_system.dto.StudentRequestDto;
import com.demo.example.student_library_management_system.model.Student;

public class StudentConverter {
    // converts the StudentRequestDto into student model class

    public static Student convertStudentRequestDtoToStudent(StudentRequestDto studentRequestDto){
        //builder - helps to build the object and set it values
        Student student = Student.builder().name(studentRequestDto.getName()).age(studentRequestDto.getAge())
                .email(studentRequestDto.getEmail()).mobile(studentRequestDto.getMobile())
                .address(studentRequestDto.getAddress()).build();
        return student;
    }
}
