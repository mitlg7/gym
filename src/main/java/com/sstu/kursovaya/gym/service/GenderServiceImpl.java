package com.sstu.kursovaya.gym.service;

import com.sstu.kursovaya.gym.model.Gender;
import com.sstu.kursovaya.gym.repository.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenderServiceImpl implements GenderService{
    @Autowired
    private GenderRepository genderRepository;
    @Override
    public List<Gender> getAll() {
        return genderRepository.getAll();
    }
}
