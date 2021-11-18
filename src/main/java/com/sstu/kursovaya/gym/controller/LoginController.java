package com.sstu.kursovaya.gym.controller;

import com.sstu.kursovaya.gym.model.utils.RegistrationRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
    @PostMapping("/registration")
    public String registration(RegistrationRequest request){
        return "null";
    }
}
