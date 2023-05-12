package com.example.postoffice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {

    @JsonProperty("status")
    int status;

    @JsonProperty("result")
    PostCodeDetails result;
}
