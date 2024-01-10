package com.LoginGrupp3.LoginGrupp3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.LoginGrupp3.LoginGrupp3.model.User;
import com.LoginGrupp3.LoginGrupp3.repository.UserRepository;

@Controller
public class NewUserController {

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/createNewAccount")
    public String getNewUserForm() {
        return "createNewAccount";
    }

    @PostMapping("/newUser")
    public String newUser(@RequestParam("firstName") String firstName, @RequestParam("surname") String surname,
            @RequestParam("email") String email, @RequestParam("username") String username,
            @RequestParam("password") String password) {

        User user = new User();
        user.setFirstName(firstName);
        user.setSurname(surname);
        user.setEmail(email);
        user.setUsername(username);
        password = bcryptEncoder.encode(password);
        user.setPassword(password);
        userRepository.save(user);
        return "redirect:/";
    }

}
