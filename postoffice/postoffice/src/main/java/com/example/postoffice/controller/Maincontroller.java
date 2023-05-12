package com.example.postoffice.controller;

import com.example.postoffice.entity.*;
import com.example.postoffice.entity.PostCodeDetails;
import com.example.postoffice.service.BackService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class Maincontroller {

    @Autowired
    BackService service;

    @PostMapping("/getcordinate/{postcode}")
    public ResponseEntity<FinalResponse> getcordinates(@PathVariable String postcode, @RequestBody String name){

            return service.getcordinates(postcode,name);

    }

    @GetMapping("/getonline/{postcode}")
    public Response getcoordinates(@PathVariable String postcode) {
        return service.getonline(postcode);
    }

    @GetMapping("/getonline1/{postcode}")
    public String getcoordinates1(@PathVariable String postcode){

        RestTemplate restTemplate=new RestTemplate();
        return restTemplate.getForObject("https://api.postcodes.io/postcodes/{postcode}",String.class,postcode);

    }

    @GetMapping("/getdemo")
    public User getdemo(){
        return service.getdemo();
    }

}
