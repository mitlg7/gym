package com.sstu.kursovaya.gym.controller;


import com.sstu.kursovaya.gym.model.Subscription;
import com.sstu.kursovaya.gym.model.Trainer;
import com.sstu.kursovaya.gym.model.utils.CreateSubRequest;
import com.sstu.kursovaya.gym.model.utils.CreateTrainerRequest;
import com.sstu.kursovaya.gym.service.ContinuanceService;
import com.sstu.kursovaya.gym.service.HallService;
import com.sstu.kursovaya.gym.service.SubscriptionService;
import com.sstu.kursovaya.gym.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SubscriptionController {

    @Autowired
    SubscriptionService subscriptionService;
    @Autowired
    TrainerService trainerService;
    @Autowired
    ContinuanceService continuanceService;
    @Autowired
    HallService hallService;


    @GetMapping("/subscription/create")
    public String getPageAddClient(Model model) {
        model.addAttribute("halls", hallService.getAll());
        model.addAttribute("trainers", trainerService.getAll());
        model.addAttribute("continuances", continuanceService.getAll());
        return "create-subscription";
    }
    @PostMapping("/subscription/create")
    public String addClient(CreateSubRequest createSubRequest) {
        subscriptionService.create(createSubRequest);
        return "redirect:/login";
    }

    @GetMapping("/subscription/{id}")
    public String getClient(Model model, @PathVariable int id) {
        Subscription subscription = subscriptionService.get(id);
        if(subscription == null){
            return "redirect:/";//todo 404
        }
        model.addAttribute("subscription", subscription);
        return "subscription-page";
    }
    @GetMapping("/subscription/all")
    public String getSubscription(Model model) {
        List<Subscription> subscriptions = subscriptionService.getAll();
        model.addAttribute("subscriptions", subscriptions);
        return "subscriptions-page";
    }
}
