package com.sstu.kursovaya.gym.service;

import com.sstu.kursovaya.gym.model.Continuance;
import com.sstu.kursovaya.gym.model.Hall;
import com.sstu.kursovaya.gym.model.Subscription;
import com.sstu.kursovaya.gym.model.Trainer;
import com.sstu.kursovaya.gym.model.utils.CreateSubRequest;
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
    public void create(CreateSubRequest createSubRequest) {
        Subscription subscription = new Subscription().setName(createSubRequest.getName())
                .setPrice(Integer.parseInt(createSubRequest.getPrice()))
                .setContinuance(new Continuance().setId(Integer.parseInt(createSubRequest.getContinuance_id())))
                .setHall(new Hall().setId(Integer.parseInt(createSubRequest.getHall_id())))
                .setTrainer(new Trainer().setId(Integer.parseInt(createSubRequest.getTrainer_id())));
        subscriptionRepository.create(subscription);
    }
}
