package com.LoginGrupp3.LoginGrupp3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class NewUserController {
    
@GetMapping("/createNewAccount")
    public String getNewUserForm() {
        return "createNewAccount";
    }

}
