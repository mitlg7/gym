package com.sstu.kursovaya.gym.service;

import com.sstu.kursovaya.gym.model.Client;
import com.sstu.kursovaya.gym.model.Gender;
import com.sstu.kursovaya.gym.model.utils.CreateClientRequest;
import com.sstu.kursovaya.gym.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client getById(int id) {
        return clientRepository.get(id);
    }

    @Override
    public List<Client> getAll() {
        return clientRepository.getAll();
    }

    @Override
    public void deleteById(int id) {
        clientRepository.delete(id);
    }

    @Override
    public void create(CreateClientRequest clientRequest) {
        Client client = new Client()
                .setFirstName(clientRequest.getName())
                .setLastname(clientRequest.getLastname())
                .setBirthday(Date.valueOf(clientRequest.getBirthday()))
                .setPhone(clientRequest.getPhone())
                .setRegistration(new java.sql.Date(Calendar.getInstance().getTimeInMillis()))
                .setGender(new Gender().setId(Integer.parseInt(clientRequest.getGender())));

        clientRepository.create(client);
    }
}
