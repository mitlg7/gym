package com.sstu.kursovaya.gym.service;

import com.sstu.kursovaya.gym.model.Admin;

public interface AdminService {
    Admin getByLogin(String login);
}
