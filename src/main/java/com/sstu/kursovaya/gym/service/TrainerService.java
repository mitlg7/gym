package com.sstu.kursovaya.gym.service;

import com.sstu.kursovaya.gym.model.Client;
import com.sstu.kursovaya.gym.model.Trainer;

import java.util.List;

public interface TrainerService {
    Trainer getById(int id);
    List<Trainer> getAll();
    void deleteById(int id);
    void create(Trainer trainer);
}
