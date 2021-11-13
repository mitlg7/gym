package com.sstu.kursovaya.gym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginForm(Model model){
        return "login";
    }
    @GetMapping("/registration")
    public String registrationForm(Model model){
        return "register";
    }
    @GetMapping("/registration")
    public String registration(Model model){
        return "register";
    }
}
