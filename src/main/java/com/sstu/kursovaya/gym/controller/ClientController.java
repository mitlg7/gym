package com.sstu.kursovaya.gym.controller;


import com.sstu.kursovaya.gym.model.Client;
import com.sstu.kursovaya.gym.model.utils.CreateClientRequest;
import com.sstu.kursovaya.gym.service.ClientService;
import com.sstu.kursovaya.gym.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClientController {

    @Autowired
    private GenderService genderService;
    @Autowired
    private ClientService clientService;

    @GetMapping("/client/create")
    public String getPageAddClient(Model model) {
        model.addAttribute("genders", genderService.getAll());
        return "create-user";
    }

    @GetMapping("/client/{id}")
    public String getClient(Model model, @PathVariable int id) {
        Client client = clientService.getById(id);
        if(client == null){
            return "redirect:/";//todo 404
        }
        model.addAttribute("client", client);
        return "user-page";
    }


    @PostMapping("/client/create")
    public String addClient(CreateClientRequest createClientRequest) {
        clientService.create(createClientRequest);
        return "redirect:/login";
    }

    @PostMapping("/client/subscription/add")
    public String addSubscription() {
        return null;
    }
}
