package com.sstu.kursovaya.gym.service;

import com.sstu.kursovaya.gym.model.Client;
import com.sstu.kursovaya.gym.model.Trainer;
import com.sstu.kursovaya.gym.model.utils.CreateTrainerRequest;

import java.util.List;

public interface TrainerService {
    Trainer getById(int id);
    List<Trainer> getAll();
    void deleteById(int id);
    void create(CreateTrainerRequest trainer);
}
