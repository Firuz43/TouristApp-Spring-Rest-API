package com.firuz.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.firuz.demo.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
