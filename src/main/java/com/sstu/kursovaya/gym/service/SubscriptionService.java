package com.sstu.kursovaya.gym.service;

import com.sstu.kursovaya.gym.model.Subscription;
import com.sstu.kursovaya.gym.model.utils.CreateSubRequest;

import java.util.List;

public interface SubscriptionService {
    Subscription get(int id);
    List<Subscription> getAll();
    void delete(int id);
    void create(CreateSubRequest subscription);
}
