package com.example.student.controller;

import com.example.student.dao.entity.student.StudentEntity;
import com.example.student.dao.entity.weather.WeatherEntity;
import com.example.student.dto.StudentDto;
import com.example.student.dto.WeatherDto;
import com.example.student.service.FromJsonService;
import com.example.student.service.StudentService;
import com.example.student.service.WeatherService;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
@Slf4j
public class StartContoller {

    @Autowired
    private StudentService studentService;
    @Autowired
    private FromJsonService fromJsonService;
    @Autowired
    private WeatherService weatherService;

    @GetMapping("get/student/adress")//Для вывода только первого студента в виде Json в браузер
    public Optional<StudentEntity> studentEntityList() {
        log.info("get student");
        return studentService.getStudent();
    }
    @PostMapping("add/student/adress")// Для сохранения объектов из Json(моего формата) в БД
    public String addStudent(@RequestBody StudentDto studentDto){
        log.info("studentDto {}", studentDto);
        studentService.addStudent(studentDto);
        return "student saved";
    }
    @GetMapping("get/all")// Вывод всех студентов моего формата в виде Json
    public List<StudentEntity>entityList(){
        return studentService.getAll();
    }

    @PostMapping("add/another/json")// Для втягивания другого Json
    public String addAnotherJson(@RequestBody StudentDto studentDto){
        fromJsonService.anotherJson(studentDto);
        return "another saved";
    }
    @GetMapping("addJsonFromOlesyaToDB")
        public String addJsonFromOlesyaToBd() throws JSONException {
        weatherService.addWeatherEntityToDB();
        return "ok";
    }
    @GetMapping("getWeather")
    public WeatherEntity getWeatherFromDB(){
        return weatherService.getweatherEntity();
    }
    @GetMapping("getWeatherDto")
    public WeatherDto getWeatherDto(){
        return weatherService.createWeatherDtoFromWeatherEntity(weatherService.getweatherEntity());
    }
}
