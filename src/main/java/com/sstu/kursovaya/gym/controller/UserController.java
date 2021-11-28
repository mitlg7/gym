package com.sstu.kursovaya.gym.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/user/create")
    public String getPageAddUser(Model model) {
        return "create-user";
    }

    @GetMapping("/user/{id}")
    public String getUser(Model model){
        return "user-page";
    }
}
