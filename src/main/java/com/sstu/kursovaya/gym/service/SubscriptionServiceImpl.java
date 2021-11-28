package com.sstu.kursovaya.gym.service;

import com.sstu.kursovaya.gym.model.Subscription;
import com.sstu.kursovaya.gym.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    @Autowired
    SubscriptionRepository subscriptionRepository;

    @Override
    public Subscription get(int id) {
        return subscriptionRepository.get(id);
    }

    @Override
    public List<Subscription> getAll() {
        return subscriptionRepository.getAll();
    }

    @Override
    public void delete(int id) {
        subscriptionRepository.delete(id);
    }

    @Override
    public void create(Subscription subscription) {
        subscriptionRepository.create(subscription);
    }
}
