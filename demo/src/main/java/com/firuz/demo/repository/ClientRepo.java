package com.firuz.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.firuz.demo.entity.Client;


@Repository
public interface ClientRepo extends JpaRepository<Client, Integer>{
    
}
