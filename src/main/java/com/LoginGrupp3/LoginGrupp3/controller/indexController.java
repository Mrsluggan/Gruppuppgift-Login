package com.LoginGrupp3.LoginGrupp3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.LoginGrupp3.LoginGrupp3.repository.CarRepository;

@Controller
public class indexController {

    @Autowired
    private CarRepository carRepository;

    @GetMapping
    public String getIndex(Model model) {
        model.addAttribute("products", carRepository.findAll());
        return "index";
    }

}
