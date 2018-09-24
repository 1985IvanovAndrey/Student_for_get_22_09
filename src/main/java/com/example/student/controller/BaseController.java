package com.example.student.controller;

import com.example.student.service.FromJsonService;
import com.example.student.service.StudentService;
import com.example.student.service.WeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class BaseController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private FromJsonService fromJsonService;
    @Autowired
    private WeatherService weatherService;


    @GetMapping("/from/json")// вывода через jsp всех полей полученного Json
    public String fromJson(Model model) {
        model.addAttribute("name", fromJsonService.anotherFields().getName());
        model.addAttribute("secname", fromJsonService.anotherFields().getSurname());
        model.addAttribute("age", fromJsonService.anotherFields().getAge());
        model.addAttribute("country", fromJsonService.anotherFields().getCountry());
        model.addAttribute("city", fromJsonService.anotherFields().getCity());
        model.addAttribute("street", fromJsonService.anotherFields().getStreet());
        model.addAttribute("number", fromJsonService.anotherFields().getNumberHouse());
        return "/index";
    }
    @GetMapping("printJsonWithDB")
    public String printJsonWithDB(Model model){
        model.addAttribute("weather",weatherService.getweatherEntity());
        return "/index2";
    }

}
