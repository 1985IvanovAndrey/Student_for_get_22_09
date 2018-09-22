package com.example.student.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class StudentDto {

    @JsonProperty("adressEntity")
    private AdressEntity adressEntity;
    @JsonProperty("age")
    private int age;
    @JsonProperty("surname")
    private String surname;
    @JsonProperty("name")
    private String name;

    @Data
    public static class AdressEntity {
        @JsonProperty("numberHouse")
        private int numberHouse;
        @JsonProperty("street")
        private String street;
        @JsonProperty("city")
        private String city;
        @JsonProperty("country")
        private String country;
    }
}
