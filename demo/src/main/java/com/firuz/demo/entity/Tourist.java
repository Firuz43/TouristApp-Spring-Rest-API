package com.firuz.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//
@Entity
public class Tourist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Integer tid;
    private String name;
    private String city;
    private String packageType;
    private double budget;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
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

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "Tourist [tid=" + tid + ", name=" + name + ", city=" + city + ", packageType=" + packageType
                + ", budget=" + budget + "]";
    }

    public Tourist(Integer tid, String name, String city, String packageType, double budget) {
        this.tid = tid;
        this.name = name;
        this.city = city;
        this.packageType = packageType;
        this.budget = budget;
    }

    public Tourist() {
    }

}
