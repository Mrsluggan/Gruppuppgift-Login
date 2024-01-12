package com.LoginGrupp3.LoginGrupp3.controller;

import java.util.Optional;
import java.util.List;

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

        //Kollar om det finns en bil i car
        if (car.isPresent()) {
            //Plockar upp bilen
            Car currentCar = car.get();
            //Skapar en lista med random cars + den aktuella med id
            List<Car> randomCars = carRepository.findRandomCarsIncludingCurrent(4, currentCar.getId());

            //Tar bort aktuella bilen
            randomCars.remove(currentCar);

            //Lägger till aktuella
            model.addAttribute("product", currentCar);
            
            model.addAttribute("otherProducts", randomCars);
            return "details";
        } else {
            // Handle case where the car with the given id is not found
            return "notfound";
        }

    }
}