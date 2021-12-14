package com.sstu.kursovaya.gym.service;

import com.sstu.kursovaya.gym.model.Client;

public interface CheckService {
    boolean check(String email);

    Client checkOpen(String token);
}
