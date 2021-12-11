package com.sstu.kursovaya.gym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping
    public String main(Model model){
        return "index";
    }

    @GetMapping("eror404")
    public String eror404(Model model){
        return "eror404";
    }

    @GetMapping("eror403")
    public String eror403(Model model){
        return "eror403";
    }

}
