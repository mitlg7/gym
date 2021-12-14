package com.sstu.kursovaya.gym.service;

import com.sstu.kursovaya.gym.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CheckServiceImpl implements CheckService {
    @Autowired
    ClientService clientService;
    @Autowired
    EmailService emailService;

    @Override
    public boolean check(String email) {
        String token = UUID.randomUUID().toString();
        List<Client> clients = clientService.getAll().stream()
                .filter(x-> !ObjectUtils.isEmpty(x.getEmail()))
                .filter(x -> x.getEmail().toUpperCase(Locale.ROOT).equals(email.toUpperCase(Locale.ROOT)))
                .collect(Collectors.toList());
        if (clients.isEmpty()) {
            return false;
        } else {
            clientService.setToken(clients.get(0).getId(), token);
            emailService.send(clients.get(0).getEmail(), "Твоя ссылка - /check?token=" + token);
        }
        return true;
    }

    @Override
    public Client checkOpen(String token) {
        List<Client> clients = clientService.getAll().stream().filter(x -> x.getToken().equals(token)).collect(Collectors.toList());

        if(clients.isEmpty())
            return null;
        else
            return clients.get(0);
    }
}
