package com.sstu.kursovaya.gym.service;

import com.sstu.kursovaya.gym.model.Hall;
import com.sstu.kursovaya.gym.repository.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HallServiceImpl implements HallService{
    @Autowired
    HallRepository hallRepository;

    @Override
    public List<Hall> getAll() {
        return hallRepository.getAll();
    }

    @Override
    public void create(Hall hall) {
        hallRepository.create(hall);
    }
}
