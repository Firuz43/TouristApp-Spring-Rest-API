package com.firuz.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firuz.demo.entity.Student;
import com.firuz.demo.exception.StudentNotFoundException;
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

    //find by id//

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

    // retrieving data by id 
    @Override
    public String updateStudent(Student student) {
        Integer id = student.getSid();
        Optional<Student> optional = studentRepository.findById(id);
        if(optional.isPresent()){
            studentRepository.save(student);
            return "Student with the id " + student.getSid() + " is updated.";
        }else {
            throw new StudentNotFoundException("Student with the id " + student.getSid() + " is not found to update");
        }
        
    }


    @Override
    public String updateStudentById(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    
}
