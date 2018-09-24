package com.example.student.dao.entity.student;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "student")
@Data
public class StudentEntity {
    @Id
    @GeneratedValue
    @JsonIgnore
    @Column
    private int id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private int age;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "adress_id")
    private AdressEntity adressEntity;

    public StudentEntity(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public StudentEntity(String name, String surname, int age, AdressEntity adressEntity) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.adressEntity = adressEntity;
    }

    public StudentEntity() {
    }
}
