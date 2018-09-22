package com.example.student.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "adress")
public class AdressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    @Column(name = "adress_id")
    private int id;

    @Column
    private String country;

    @Column
    private String city;

    @Column
    private String street;

    @Column
    private int numberHouse;

    public AdressEntity(String country, String city, String street, int numberHouse) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.numberHouse = numberHouse;
    }

    public AdressEntity() {
    }
}
