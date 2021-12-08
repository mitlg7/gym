package com.sstu.kursovaya.gym.service;

import com.sstu.kursovaya.gym.model.Trainer;
import com.sstu.kursovaya.gym.model.utils.CreateTrainerRequest;
import com.sstu.kursovaya.gym.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerServiceImpl implements TrainerService {
    @Autowired
    private TrainerRepository trainerRepository;

    @Override
    public Trainer getById(int id) {
        return trainerRepository.get(id);
    }

    @Override
    public List<Trainer> getAll() {
        return trainerRepository.getAll();
    }

    @Override
    public void deleteById(int id) {
        trainerRepository.delete(id);
    }

    @Override
    public void create(CreateTrainerRequest trainer) {
        trainerRepository.create(trainer);
    }
}
