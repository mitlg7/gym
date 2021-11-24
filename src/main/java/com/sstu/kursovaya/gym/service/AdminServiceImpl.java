package com.sstu.kursovaya.gym.service;

import com.sstu.kursovaya.gym.model.Admin;
import com.sstu.kursovaya.gym.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    AdminRepository adminRepository;

    @Override
    public Admin getByLogin(String login) {
        return adminRepository.get(login);
    }
}
