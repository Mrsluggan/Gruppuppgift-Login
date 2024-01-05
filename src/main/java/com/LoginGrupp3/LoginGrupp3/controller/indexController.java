package com.LoginGrupp3.LoginGrupp3.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.LoginGrupp3.LoginGrupp3.model.Car;
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

    // Tog bort mappingen under. Konflikt om man har två som ska till samma ställe?

    // @GetMapping("/details")
    // public String getDetails(Model model) {
    // model.addAttribute("products", carRepository.findAll());
    // return "details";
    // }

    @GetMapping("/details/{id}")
    public String getDetailsId(Model model, @PathVariable(value = "id") int id) {
        System.out.println(id);
        Optional<Car> car = carRepository.findById(id); // tog bort .get
        model.addAttribute("product", car.get());
        System.out.println("vad är detta?" + model);
        System.out.println(car.get().getId());
        return "details"; // tog bort /{id}
    }

}
