package com.sstu.kursovaya.gym.service;

import com.sstu.kursovaya.gym.model.Client;
import com.sstu.kursovaya.gym.model.utils.CreateClientRequest;

import java.util.List;

public interface ClientService {
    Client getById(int id);
    List<Client> getAll();
    void deleteById(int id);
    void create(CreateClientRequest client);
}
