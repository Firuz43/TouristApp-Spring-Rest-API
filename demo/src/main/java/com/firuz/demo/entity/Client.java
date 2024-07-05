package com.firuz.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int budget;

    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getBudget() {
        return budget;
    }
    public void setBudget(int budget) {
        this.budget = budget;
    }


    public Client(int id, String name, int budget) {
        this.id = id;
        this.name = name;
        this.budget = budget;
    }




    @Override
    public String toString() {
        return "Client [id=" + id + ", name=" + name + ", budget=" + budget + "]";
    }

    
    public Client() {
    }


    

}
