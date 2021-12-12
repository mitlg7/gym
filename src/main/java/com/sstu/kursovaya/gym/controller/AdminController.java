package com.sstu.kursovaya.gym.controller;

import com.sstu.kursovaya.gym.model.Continuance;
import com.sstu.kursovaya.gym.model.Hall;
import com.sstu.kursovaya.gym.model.Position;
import com.sstu.kursovaya.gym.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {
    @Autowired
    SubscriptionService subscriptionService;
    @Autowired
    TrainerService trainerService;
    @Autowired
    ContinuanceService continuanceService;
    @Autowired
    HallService hallService;
    @Autowired
    PositionService positionService;
    @Autowired
    ClientService clientService;

    @GetMapping("/manage")
    public String managePage(Model model) {
        model.addAttribute("halls", hallService.getAll());
        model.addAttribute("continuances", continuanceService.getAll());
        model.addAttribute("positions", positionService.getAll());

        return "manage-page";
    }

    @PostMapping("/admin/hall/add")
    public String add(Hall hall) {
        if (hall != null && !hall.getName().isEmpty())
            hallService.create(hall);
        return "redirect:/manage";
    }

    @PostMapping("/admin/continuance/add")
    public String add(Continuance continuance) {
        if (continuance != null && !continuance.getType().isEmpty() && !(continuance.getDays() == 0))
            continuanceService.create(continuance);
        return "redirect:/manage";
    }

    @PostMapping("/admin/position/add")
    public String add(Position position) {
        if (position != null && !position.getType().isEmpty())
            positionService.create(position);
        return "redirect:/manage";
    }

    @GetMapping("/admin/clients")
    public String clients(Model model){
        model.addAttribute("clients", clientService.getAll());
        return "clients-page";
    }
    @PostMapping("/admin/client/delete")
    public String deleteClient(String id){
        clientService.deleteById(Integer.parseInt(id));
        return "redirect:/admin/clients";
    }
}
