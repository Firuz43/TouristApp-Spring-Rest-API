package com.firuz.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer sid;
    private String name;
    private String city;
    
    
    public Integer getSid() {
        return sid;
    }
    public void setSid(Integer sid) {
        this.sid = sid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    
    
    @Override
    public String toString() {
        return "Student [sid=" + sid + ", name=" + name + ", city=" + city + "]";
    }
    
    
    
    
    public Student(Integer sid, String name, String city) {
        this.sid = sid;
        this.name = name;
        this.city = city;
    }


    public Student() {
    }

    
}
