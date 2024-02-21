package com.firuz.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firuz.demo.entity.Tourist;
import com.firuz.demo.service.TouristManagement;

@RestController
@RequestMapping("/api")
public class TouristController {

    @Autowired
    private TouristManagement touristService;

    @PostMapping("/register")
    public ResponseEntity<String> enrollTourist(@RequestBody Tourist tourist) {

        String msg = touristService.registerTourist(tourist);

        return new ResponseEntity<String>(msg, HttpStatus.OK);

    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> getTouristById(@PathVariable("id") Integer id) {

        Tourist tourist = touristService.fetchTouristById(id);
        return new ResponseEntity<>(tourist, HttpStatus.OK);

    }

    @GetMapping("/findall")
    public ResponseEntity<?> getAllTourists() {

        List<Tourist> tourists = touristService.fetchAllTourist();

        return new ResponseEntity<>(tourists, HttpStatus.OK);

    }

    @PutMapping("/update")
    public ResponseEntity<String> updateTourist(@RequestBody Tourist tourist) {

        String status = touristService.updateTouristData(tourist);
        return new ResponseEntity<String>(status, HttpStatus.OK);

    }

    @PatchMapping("/updateBudget/{id}/{budget}")
    public ResponseEntity<String> updateTourist(@PathVariable("id") Integer id,
            @PathVariable("budget") Double budget) {

        String status = touristService.updateTouristDataById(id, budget);
        return new ResponseEntity<String>(status, HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTourist(@PathVariable("id") Integer id) {

        String status = touristService.deleteTourist(id);
        return new ResponseEntity<String>(status, HttpStatus.OK);

    }
}
