package com.example.postoffice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "POSTENT")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostEntity{


    @Id
    String postcode;

    @Column
    double lon;

    @Column
    double lat;

}
