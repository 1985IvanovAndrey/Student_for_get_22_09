package com.example.student.service;


import com.example.student.dao.entity.AdressEntity;
import com.example.student.dao.entity.FromJsonEntity;
import com.example.student.dao.entity.StudentEntity;
import com.example.student.dto.StudentDto;
import com.example.student.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;


    public Optional<StudentEntity> getStudent() {
        return studentRepository.findById(1);
    }

    public String addStudent(StudentDto studentDto) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName(studentDto.getName());
        studentEntity.setSurname(studentDto.getSurname());
        studentEntity.setAge(studentDto.getAge());

        AdressEntity adressEntity = new AdressEntity();
        adressEntity.setCountry(studentDto.getAdressEntity().getCountry());
        adressEntity.setCity(studentDto.getAdressEntity().getCity());
        adressEntity.setStreet(studentDto.getAdressEntity().getStreet());
        adressEntity.setNumberHouse(studentDto.getAdressEntity().getNumberHouse());

        studentEntity.setAdressEntity(adressEntity);

        try {
            studentRepository.saveAndFlush(studentEntity);
            log.info("student saved");
            return " student saved";
        } catch (Exception e) {
            log.error(" student don't save");
            e.printStackTrace();
            return " Error! Student don't save";
        }
    }
    public List<StudentEntity>getAll(){
        return studentRepository.findAll();
    }

}
