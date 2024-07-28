package com.firuz.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firuz.demo.entity.Student;
import com.firuz.demo.repository.StudentRepo;

@Service
public class StudentManagImpl implements StudentManag {
    

    @Autowired
    private StudentRepo studentRepository;

    @Override
    public String registerStudent(Student student) {

        Integer id = studentRepository.save(student).getSid();

        // TODO Auto-generated method stub
        return "Student data stored with id " + id;
    }

    @Override
    public Student getStudentById(Integer id) {
        // Optional optional = studentRepository.findById(id);
        // Object touristObject = optional.get();
        // return touristObject;
        

    }

    @Override
    public List<Student> getAllStudents() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllStudents'");
    }

    
}
