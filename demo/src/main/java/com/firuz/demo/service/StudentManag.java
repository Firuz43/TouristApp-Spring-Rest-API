package com.firuz.demo.service;

import java.util.List;

import com.firuz.demo.entity.Student;

public interface StudentManag {
    public String registerStudent(Student student);

    public Student getStudentById(Integer id);

    public List<Student> getAllStudents();

}
