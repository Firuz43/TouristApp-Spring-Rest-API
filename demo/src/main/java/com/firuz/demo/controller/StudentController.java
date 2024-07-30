package com.firuz.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firuz.demo.entity.Student;
import com.firuz.demo.service.StudentManag;


@RestController
public class StudentController {
    
    @Autowired
    private StudentManag studentService;


    @PostMapping("/save")
    public ResponseEntity<String> saveStudent(Student student) {
        String msg = studentService.registerStudent(student);

        return new ResponseEntity<>(msg, HttpStatus.OK);
    }


    public ResponseEntity<?> findAll() {
        
        List<Student> students = studentService.getAllStudents();

        return new ResponseEntity<>(students, HttpStatus.OK);
        
    }
}
