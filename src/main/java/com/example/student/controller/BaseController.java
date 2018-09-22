package com.example.student.controller;

import com.example.student.dao.entity.StudentEntity;
import com.example.student.service.FromJsonService;
import com.example.student.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
@Slf4j
public class BaseController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private FromJsonService fromJsonService;


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

}
