package com.sstu.kursovaya.gym.controller;

import com.sstu.kursovaya.gym.model.Client;
import com.sstu.kursovaya.gym.model.Trainer;
import com.sstu.kursovaya.gym.model.utils.CreateClientRequest;
import com.sstu.kursovaya.gym.model.utils.CreateTrainerRequest;
import com.sstu.kursovaya.gym.service.GenderService;
import com.sstu.kursovaya.gym.service.PositionService;
import com.sstu.kursovaya.gym.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TrainerController {
    @Autowired
    TrainerService trainerService;
    @Autowired
    PositionService positionService;

    @Autowired
    private GenderService genderService;

    @GetMapping("/trainer/create")
    public String getPageAddClient(Model model) {
        model.addAttribute("genders", genderService.getAll());
        model.addAttribute("positions", positionService.getAll());
        return "create-trainer";
    }

    @PostMapping("/trainer/create")
    public String addClient(CreateTrainerRequest createTrainerRequest) {
        trainerService.create(createTrainerRequest);
        return "redirect:/login";
    }

    @GetMapping("/trainer/{id}")
    public String getClient(Model model, @PathVariable int id) {
        Trainer trainer = trainerService.getById(id);
        if(trainer == null){
            return "redirect:/";//todo 404
        }
        model.addAttribute("trainer", trainer);
        return "trainer-page";
    }
    @GetMapping("/trainer/all")
    public String getTrainers(Model model) {
        List<Trainer> trainers = trainerService.getAll();
        model.addAttribute("trainers", trainers);
        return "trainers-page";
    }

}
