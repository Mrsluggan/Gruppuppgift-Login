package com.LoginGrupp3.LoginGrupp3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NewUserController {

@GetMapping("/createNewAccount")
    public String getNewUserForm() {
        return "createNewAccount";
    }

@PostMapping ("/newUser")
    public String newUser  (@RequestParam("firstName") String firstName,@RequestParam("surname") String surname,
@RequestParam("email") String email, @RequestParam("username") String username, @RequestParam("password") String password) {
        
System.out.println(firstName + surname+email+username+password);
return "redirect:/";
}




}
