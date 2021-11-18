package com.sstu.kursovaya.gym.controller;


import com.sstu.kursovaya.gym.model.utils.CreateUserRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClientController {

    @GetMapping("/client/create")
    public String getPageAddClient(Model model) {
        return "create-user";
    }

    @GetMapping("/client/{id}")
    public String getClient(Model model) {
        return "user-page";
    }


    @PostMapping("/client/create")
    public String addClient(CreateUserRequest createUserRequest) {
        return null;
    }

    @PostMapping("/client/subscription/add")
    public String addSubscription() {
        return null;
    }
}
