package com.example.student.dao.entity.weather;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "weather_entity")
public class WeatherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    @Column(name = "id_weather")
    private long id;
    @Column
    private int tempMax;
    @Column
    private int tempMin;
    @Column
    private int pressure;
    @Column
    private String nameCity;
    @Column
    private String date;

    @Column
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CloudEntity> cloudEntityList;

    public WeatherEntity(int tempMax, int tempMin, int pressure, String nameCity, String date, List<CloudEntity> cloudEntityList) {
        this.tempMax = tempMax;
        this.tempMin = tempMin;
        this.pressure = pressure;
        this.nameCity = nameCity;
        this.date = date;
        this.cloudEntityList = cloudEntityList;
    }
}
