package com.sstu.kursovaya.gym.controller;

import com.sstu.kursovaya.gym.model.Client;
import com.sstu.kursovaya.gym.service.AccountingService;
import com.sstu.kursovaya.gym.service.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CheckController {
    @Autowired
    CheckService checkService;
    @Autowired
    AccountingService accountingService;

    @GetMapping("/check")
    public String getCheckkkkk(Model model, @RequestParam(required = false) String token,
                               @RequestParam(required = false) String valid) {
        if(valid == null){
            if (token != null) {
                Client client = checkService.checkOpen(token);
                if (client != null) {
                    model.addAttribute("client", client);
                    model.addAttribute("accs", accountingService.getByClient(client.getId()));
                } else {
                    model.addAttribute("error", "Токен не валидный");
                }
            }
        }else {
            if(valid.equals("no")){
                model.addAttribute("valid", "no");
            }else {
                model.addAttribute("valid", "yes");
            }
        }

        return "check";
    }

    @PostMapping("/check")
    public String check(String email) {
        if (checkService.check(email))
            return "redirect:/check?valid=yes";
        else
            return "redirect:/check?valid=no";
    }

    @GetMapping("/map")
    public String map(Model model){
        return "map";
    }
}
