package com.sstu.kursovaya.gym.service;

import com.sstu.kursovaya.gym.model.Position;

import java.util.List;

public interface PositionService {
    List<Position> getAll();
    void create(Position position);
}
