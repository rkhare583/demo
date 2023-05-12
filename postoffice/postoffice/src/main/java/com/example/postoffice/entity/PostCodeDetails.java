package com.example.postoffice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.net.MalformedURLException;
import java.net.URL;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostCodeDetails {

   @JsonProperty(namespace = "postcode")
   String postcode;

  @JsonProperty(namespace = "longitude")
   double longitude;

  @JsonProperty(namespace = "latitude")
   double latitude;


}