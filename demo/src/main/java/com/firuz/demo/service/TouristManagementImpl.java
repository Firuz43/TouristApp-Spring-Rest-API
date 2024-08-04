package com.firuz.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firuz.demo.entity.Tourist;
import com.firuz.demo.exception.TouristNotFoundException;
import com.firuz.demo.repository.TouristRepoi;

@Service
public class TouristManagementImpl implements TouristManagement {


    // We will inject our repository class in the implementation class
    @Autowired
    private TouristRepoi touristRepository;

    // Saving Tourist to database;
    @Override
    public String registerTourist(Tourist tourist) {
        Integer id = touristRepository.save(tourist).getTid();
        return "Tourist data stored with id " + id;
    }

    // Fetching tourist by id; /// foofosds
    @Override
    public Tourist fetchTouristById(Integer id) {
        return touristRepository.findById(id)
                .orElseThrow(() -> new TouristNotFoundException("Tourist with  id " + id + " not found"));
    }

    // Fetching list of tourists from database the new changes
    @Override
    public List<Tourist> fetchAllTourist() {
        List<Tourist> list = touristRepository.findAll();

        return list;
        ///return something
    }

    @Override
    public String updateTouristData(Tourist tourist) {

        Optional<Tourist> optional = touristRepository.findById(tourist.getTid());
        if (optional.isPresent()) {
            touristRepository.save(tourist);
            return "Tourist with the id " + tourist.getTid() + " is updated";
        } else {
            throw new TouristNotFoundException("Tourist with the id " + tourist.getTid() + " not found to update.");
        }
    }

    // updating tourist by id//// this ///
    @Override
    public String updateTouristDataById(Integer id, Double budget) {

        Optional<Tourist> optional = touristRepository.findById(id);
        if (optional.isPresent()) {
            Tourist tourist = optional.get();
            tourist.setBudget(budget);
            touristRepository.save(tourist);
            return "Tourist with the id " + tourist.getTid() + " is updated";
        } else {
            throw new TouristNotFoundException("Tourist with the id " + id + " not found to update.");
        }
    }

    //Throwing exception /////
    @Override
    public String deleteTourist(Integer id) {
        Optional<Tourist> optional = touristRepository.findById(id);
        if (optional.isPresent()) {
            Tourist tourist = optional.get();
            touristRepository.delete(tourist);
            return "Tourist with the id " + tourist.getTid() + " is deleted";
        } else {
            throw new TouristNotFoundException("Tourist with the id " + id + " not found to delete.");
        }
    }


    

}
