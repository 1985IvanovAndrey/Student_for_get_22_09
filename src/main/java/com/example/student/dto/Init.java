package com.example.student.dto;

import com.example.student.dao.entity.student.AdressEntity;
import com.example.student.dao.entity.student.StudentEntity;
import com.example.student.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j

public class Init {

    @Autowired
    private StudentRepository studentRepository;

    @PostConstruct
    private void init() {
        log.info("--->>init and save student with adress");
        StudentEntity studentEntity=new StudentEntity("Leo","Messi",32);
        AdressEntity adressEntity =new AdressEntity("Spain","Barselona","Central",10);
        studentEntity.setAdressEntity(adressEntity);
        studentRepository.saveAndFlush(studentEntity);
    }
}
