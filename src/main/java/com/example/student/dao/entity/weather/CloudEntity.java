package com.example.student.dao.entity.weather;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cloud_entity")
public class CloudEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    @Column(name = "id_cloud")
    private long id;
    @Column
    private String description;
    @Column
    private String main;

    public CloudEntity(String description, String main) {
        this.description = description;
        this.main = main;
    }

    public CloudEntity() {
    }
}
