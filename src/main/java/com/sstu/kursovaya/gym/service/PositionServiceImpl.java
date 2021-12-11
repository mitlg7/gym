package com.sstu.kursovaya.gym.service;

import com.sstu.kursovaya.gym.model.Position;
import com.sstu.kursovaya.gym.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService{
    @Autowired
    PositionRepository positionRepository;

    @Override
    public List<Position> getAll() {
        return positionRepository.getAll();
    }

    @Override
    public void create(Position position) {
        positionRepository.create(position);
    }
}
