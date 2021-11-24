package com.sstu.kursovaya.gym.controller;

import com.sstu.kursovaya.gym.model.utils.RegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String loginForm(Model model){
        System.out.println(passwordEncoder.encode("admin"));
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
