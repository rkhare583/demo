package com.example.postoffice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    int userId;
    int id;
    String title;
    @JsonProperty("completed")
    String cos;
}
