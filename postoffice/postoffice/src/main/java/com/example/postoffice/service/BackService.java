package com.example.postoffice.service;

import com.example.postoffice.entity.*;
import com.example.postoffice.repository.Repo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class BackService {

    @Autowired
    Repo repo;

    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<FinalResponse> getcordinates(String postcode,String name){
        Optional<PostEntity> pe=repo.findById(postcode);
        if(pe.isPresent()){
            double lon=pe.get().getLon();
            double lat=pe.get().getLat();
            return new ResponseEntity(new FinalResponse("Congratulations "+ name+ " Lat: " + lat + " long: " + lon),new HttpHeaders(), HttpStatus.OK);
        }
        else{
            Response rs=getonline(postcode);
            PostEntity p=new PostEntity(postcode,rs.getResult().getLatitude(),rs.getResult().getLongitude());
            repo.save(p);
            return new ResponseEntity(new FinalResponse("Congratulations "+ name+ " Lat: " + p.getLat() + " long: " + p.getLon()),new HttpHeaders(), HttpStatus.OK);
        }
        //return new ResponseEntity(new FinalResponse("Sorry "+ name + " we haven't found such postcode"),new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    public Response getonline(String postcode){
       return restTemplate.getForObject("https://api.postcodes.io/postcodes/{postcode}", Response.class,postcode);
    }

    public User getdemo(){
        return restTemplate.getForObject("https://jsonplaceholder.typicode.com/todos/1", User.class);
    }
}
