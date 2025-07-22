package com.demo.example.student_library_management_system.controller;

import com.demo.example.student_library_management_system.dto.StudentRequestDto;
import com.demo.example.student_library_management_system.model.Student;
import com.demo.example.student_library_management_system.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/api")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // ResponseEntity - inbuilt class for sending the standard response from APIs
    // Loggers - displays message in console which helps in tracking of the application flow
    /*
    diiferent levels of loggers
    info - displays the normal information
    error - to display error or exception messages
    warn - to display warning message
    debug - while running application in debug mode
     */

    // declaring loggers
    Logger logger = LoggerFactory.getLogger(StudentController.class);

    @PostMapping("/save")
    public ResponseEntity<?> saveStudent(@RequestBody StudentRequestDto studentRequestDto){
        logger.info("saveStudent API started");
        try {
            String response = studentService.addStudent(studentRequestDto);
            logger.info("saveStudent API ended");
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            logger.error("saveStudent API caught with exception : "+e.getMessage());
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> getAllStudent(){
        try {
            List<Student> studentList = studentService.getAll();
            return ResponseEntity.ok().body(studentList);
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/find/{studentid}")
    public ResponseEntity<?> getStudentById(@PathVariable("studentid") int studentId){
        logger.info("getStudentById API started");
        try {
            Student student = studentService.getStudentById(studentId);
            logger.info("getStudentById API ended");
            return ResponseEntity.ok(student);
        }catch (Exception e){
            logger.error("getStudentById API caught with exception : "+e.getMessage());
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{studentid}")
    public ResponseEntity<?> deleteStudentById(@PathVariable("studentid") int studentId){
        try {
            String response = studentService.deleteStudentById(studentId);
            return ResponseEntity.ok(response);
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/getCount")
    public String countStudents(){
        String response = studentService.countStudent();
        return response;
    }

    @PutMapping("/update/{studentid}")
    public ResponseEntity<?> updateStudent(@RequestBody StudentRequestDto studentRequestDto,@PathVariable("studentid") int studentId){
        try {
            String response = studentService.updateStudent(studentRequestDto, studentId);
            return ResponseEntity.ok(response);
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/findPage")
    public List<Student> getAllStudentsWithPage(@RequestParam("pageNo") int pageNo, @RequestParam("pageSize") int pageSize, @RequestParam("sortInput") String sortInput){
        List<Student> studentList = studentService.getAllStudentsByPage(pageNo,pageSize, sortInput);
        return studentList;
    }

    @GetMapping("/findByEmail")
    public Student getStudentByEmail(@RequestParam("email") String email){
        Student student = studentService.getStudentByEmail(email);
        return student;
    }

    @GetMapping("/findByEmailQuery")
    public Student getStudentByEmailQuery(@RequestParam("email") String email){
        Student student = studentService.getStudentByEmailQuery(email);
        return student;
    }
}
