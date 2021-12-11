package com.sstu.kursovaya.gym.controller;

import com.sstu.kursovaya.gym.model.Hall;
import com.sstu.kursovaya.gym.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HallController {
    @Autowired
    HallService hallService;

    @GetMapping("/hall/all")
    public String getHall(Model model){
        List<Hall> halls = hallService.getAll();
        model.addAttribute("halls", halls);
        return "halls-page";
    }
}
