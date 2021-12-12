package com.sstu.kursovaya.gym.controller;


import com.sstu.kursovaya.gym.model.Accounting;
import com.sstu.kursovaya.gym.model.Client;
import com.sstu.kursovaya.gym.model.Subscription;
import com.sstu.kursovaya.gym.model.utils.CreateClientRequest;
import com.sstu.kursovaya.gym.service.AccountingService;
import com.sstu.kursovaya.gym.service.ClientService;
import com.sstu.kursovaya.gym.service.GenderService;
import com.sstu.kursovaya.gym.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Calendar;
import java.util.List;

@Controller
public class ClientController {

    @Autowired
    private GenderService genderService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private SubscriptionService subscriptionService;
    @Autowired
    private AccountingService accountingService;

    @GetMapping("/client/create")
    public String getPageAddClient(Model model) {
        model.addAttribute("genders", genderService.getAll());
        return "create-user";
    }

    @GetMapping("/client/{id}")
    public String getClient(Model model, @PathVariable int id) {
        Client client = clientService.getById(id);
        if (client == null) {
            return "redirect:/";//todo 404
        }
        model.addAttribute("client", client);
        model.addAttribute("accounting", accountingService.getByClient(id));
        return "user-page";
    }

    @GetMapping("/client/{id}/accounting")
    public String getClientAccounting(Model model, @RequestParam(required = false) String subId, @PathVariable int id) {
        Client client = clientService.getById(id);

        if (client == null) {
            return "redirect:/";//todo 404
        }
        if(subId != null){
            Subscription subscription = subscriptionService.get(Integer.parseInt(subId));
            if(subscription != null){
                model.addAttribute("trainer", subscription.getTrainer());
                model.addAttribute("hall", subscription.getHall());
                model.addAttribute("subId", Integer.parseInt(subId));
            }
        }



        List<Subscription> subscriptions = subscriptionService.getAll();
        model.addAttribute("client", client);
        model.addAttribute("date", new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
        model.addAttribute("subs", subscriptions);
        return "create-accounting";
    }

    @PostMapping("/client/{id}/accounting")
    public String getClientAccounting(@PathVariable int id, String sub) {
        Client client = clientService.getById(id);

        if (client == null) {
            return "redirect:/";//todo 404
        }
        int subId = Integer.parseInt(sub);

        Accounting accounting = new Accounting()
                .setClient(clientService.getById(id))
                .setStart(new java.sql.Date(Calendar.getInstance().getTimeInMillis()))
                .setEnd(new java.sql.Date(Calendar.getInstance().getTimeInMillis()
                        + (long) subscriptionService.get(subId).getContinuance().getDays() * 24 * 60 * 60 * 1000))
                .setSubscription(subscriptionService.get(subId));

        accountingService.create(accounting);
        return "redirect:/client/"+id;
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
