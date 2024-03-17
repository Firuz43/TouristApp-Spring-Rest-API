package com.firuz.demo.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.firuz.demo.entity.Student;
import com.firuz.demo.repository.StudentRepo;

public class StudentManagementImpl implements StudentManagementI {

    @Autowired
    private StudentRepo studentRepository;

    @Override
    public Student fetchStudentById(Integer id) {
        return studentRepository.findById(id).orElseThrow();
    }

}
