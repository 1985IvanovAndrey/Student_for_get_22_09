package com.example.student.dao.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "from_json")
@Data
public class FromJsonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private int age;

    @Column
    private String country;
    @Column
    private String city;
    @Column
    private String street;
    @Column
    private int numberHouse;

    public FromJsonEntity(String surname, int age, String country, String city, String street, int numberHouse) {
        this.surname = surname;
        this.age = age;
        this.country = country;
        this.city = city;
        this.street = street;
        this.numberHouse = numberHouse;
    }

    public FromJsonEntity() {
    }
}
