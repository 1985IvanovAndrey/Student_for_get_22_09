package com.example.student.service;

import com.example.student.dao.entity.FromJsonEntity;
import com.example.student.dto.StudentDto;
import com.example.student.repository.FromJsonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class FromJsonService {

    @Autowired
    private FromJsonRepository fromJsonRepository;

    public String anotherJson(StudentDto studentDto) {

        FromJsonEntity fromJsonEntity = new FromJsonEntity();
        fromJsonEntity.setName(studentDto.getName());
        fromJsonEntity.setSurname(studentDto.getSurname());
        fromJsonEntity.setAge(studentDto.getAge());
        fromJsonEntity.setCountry(studentDto.getAdressEntity().getCountry());
        fromJsonEntity.setCity(studentDto.getAdressEntity().getCity());
        fromJsonEntity.setStreet(studentDto.getAdressEntity().getStreet());
        fromJsonEntity.setNumberHouse(studentDto.getAdressEntity().getNumberHouse());

        try {
            fromJsonRepository.saveAndFlush(fromJsonEntity);
            log.info("another saved");
            return "another saved";
        } catch (Exception e) {
            log.error(" another don't save");
            e.printStackTrace();
            return " Error! Another don't save";
        }
    }
    public FromJsonEntity anotherFields(){
        FromJsonEntity fromJsonEntity=new FromJsonEntity();
        for (int i = 0; i <fromJsonRepository.findAll().size() ; i++) {
            fromJsonEntity=fromJsonRepository.getOne(i+1);
        }
        return fromJsonEntity;
    }
}


