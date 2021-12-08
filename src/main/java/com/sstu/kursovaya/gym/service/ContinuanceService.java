package com.sstu.kursovaya.gym.service;

import com.sstu.kursovaya.gym.model.Continuance;

import java.util.List;

public interface ContinuanceService {
    List<Continuance> getAll();
    void create(Continuance continuance);
}
