package com.firuz.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firuz.demo.entity.Student;
import com.firuz.demo.exception.TouristNotFoundException;
import com.firuz.demo.repository.StudentRepo;

@Service
public class StudentManagImpl implements StudentManag {
    

    @Autowired
    private StudentRepo studentRepository;

    @Override
    public String registerStudent(Student student) {

        Integer id = studentRepository.save(student).getSid();

        return "Student data stored with id " + id;
    }

    //find by id

    @Override
    public Student getStudentById(Integer id) {
        // Optional optional = studentRepository.findById(id);
        // Object touristObject = optional.get();
        // return touristObject; //

        return studentRepository.findById(id).orElseThrow(() -> new TouristNotFoundException("Tourist with id " + id + " Not found"));


    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = studentRepository.findAll();

        return students;
    }

    
}
