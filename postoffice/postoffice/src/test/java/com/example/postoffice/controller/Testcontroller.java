package com.example.postoffice.controller;


import com.example.postoffice.entity.User;
import com.example.postoffice.service.BackService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import static org.junit.Assert.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//WebMvcTest
//Mockmvc
//@InjectMock
//@Mock
//@Order

public class Testcontroller {


    @Autowired
    TestRestTemplate testRestTemplate;

    @Mock
    BackService service;
    @InjectMocks

    @Test
    void testendpoint(){
        User u2=new User();
        u2.setId(1);
        u2.setCos("false");
        u2.setTitle("delectus aut autem");
        u2.setUserId(1);
        User u1=testRestTemplate.getForObject("https://jsonplaceholder.typicode.com/todos/1", User.class);
        User u2=
        assertEquals(u2,u1);
    }



}
