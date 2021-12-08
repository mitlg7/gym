package com.sstu.kursovaya.gym.service;

import com.sstu.kursovaya.gym.model.Continuance;
import com.sstu.kursovaya.gym.repository.ContinuanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContinuanceServiceImpl implements ContinuanceService{
    @Autowired
    ContinuanceRepository continuanceRepository;

    @Override
    public List<Continuance> getAll() {
        return continuanceRepository.getAll();
    }

    @Override
    public void create(Continuance continuance) {
        continuanceRepository.create(continuance);
    }
}
