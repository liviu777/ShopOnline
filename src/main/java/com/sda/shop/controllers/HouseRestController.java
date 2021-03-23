package com.sda.shop.controllers;

import com.sda.shop.entities.HouseEntity;
import com.sda.shop.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HouseRestController {
    @Autowired
    private HouseRepository houseRepository;
    public HouseRestController() {


    }

    @GetMapping("/api/houses")
    public List<HouseEntity> getHouses(){
        return houseRepository.findAll();
    }

    @GetMapping("/api/house/{id}")
    public HouseEntity getHouse(@PathVariable Integer id){
        return houseRepository.findById(id).get();
    }
}
