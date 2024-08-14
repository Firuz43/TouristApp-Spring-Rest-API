package com.firuz.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.firuz.demo.entity.Student;
import com.firuz.demo.service.StudentManag;


@RestController
public class StudentController {
    
    @Autowired
    private StudentManag studentService;


    @PostMapping("/save")
    public ResponseEntity<String> saveStudent(@RequestBody Student student) {

        String msg = studentService.registerStudent(student);
        return new ResponseEntity<>(msg, HttpStatus.OK);
  
    }


    @GetMapping("findById/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id") Integer id) {
        Student student = studentService.getStudentById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);

    }
    
    @GetMapping("/findall")
    public ResponseEntity<?> findAll() {
        
        List<Student> students = studentService.getAllStudents();

        return new ResponseEntity<>(students, HttpStatus.OK);

    }

    // sssss
    @PutMapping("/update")
    public ResponseEntity<String> updateStudentData(@RequestBody Student student) {

        String status = studentService.updateStudent(student);

        return new ResponseEntity<>(status, HttpStatus.OK);
   
    }



    @PatchMapping("/update/{id}/{name}")
    public ResponseEntity<String> updateStudentName(@PathVariable("id")Integer id, 
                                                    @PathVariable("name") String name){

        String status = studentService.updateStudentById(id, name);
        return new ResponseEntity<>(status, HttpStatus.OK);

    }


    //deleting api

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Integer id) {

        String status = studentService.deleteStudent(id);
        return new ResponseEntity<>(status, HttpStatus.OK);

    }
}
