package com.example.student.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class WeatherDto {

    @JsonProperty("Weather")
    public List<Weather> Weather;


    @Data
    public static class CloudWeather {
        @JsonProperty("main")
        private String main;
        @JsonProperty("description")
        private String description;
    }

    @Data
    public static class Weather {
        @JsonProperty("tempMin")
        private int tempMin;
        @JsonProperty("CloudWeather")
        private List<CloudWeather> CloudWeather;
        @JsonProperty("pressure")
        private int pressure;
        @JsonProperty("nameCity")
        private String nameCity;
        @JsonProperty("date")
        private String date;
        @JsonProperty("tempMax")
        private int tempMax;
    }
}