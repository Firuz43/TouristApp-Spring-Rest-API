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

    // updating all student data
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
    public String updateStudentById(Integer id, String name) {
        Optional<Student> optional = studentRepository.findById(id);
        if(optional.isPresent()) {
            Student student = optional.get(); // it will give us back entire student object;
            student.setName(name);            //then we will update name that we get from pathvariable with help of setter
            studentRepository.save(student);  // after we updated the name we just save back the student object
            return "Tourist with id " + student.getSid() + " is updated";
        }else {
            throw new StudentNotFoundException("Student with the id " + id + " is not found to update");
        }
    }

    @Override
    public String deleteStudent(Integer id) {
        Optional<Student> optional = studentRepository.findById(id);

        if(optional.isPresent()) {
            Student student = optional.get();  //

            studentRepository.delete(student);
        }

        return "";
    }
}
