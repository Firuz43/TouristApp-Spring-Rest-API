package com.firuz.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.firuz.demo.entity.Student;
import com.firuz.demo.exception.TouristNotFoundException;
import com.firuz.demo.service.StudentManag;


@RestController
public class StudentController {
    
    @Autowired
    private StudentManag studentService;


    @PostMapping("/save")
    public ResponseEntity<String> saveStudent(@RequestBody Student student) {

        try {
            String msg = studentService.registerStudent(student);

            return new ResponseEntity<>(msg, HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<>("Some problem in saving student data", HttpStatus.INTERNAL_SERVER_ERROR);
        } 
  
    }


    @GetMapping("/findall")
    public ResponseEntity<?> findAll() {
        
        try {
            List<Student> students = studentService.getAllStudents();

            return new ResponseEntity<>(students, HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<>("Some problem in getting all students data", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        
    }



    @GetMapping("findById/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id") Integer id) {

        try{
            Student student = studentService.getStudentById(id);

            return new ResponseEntity<>(student, HttpStatus.OK);
        }catch(TouristNotFoundException tn) {
            return new ResponseEntity<>(tn.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
