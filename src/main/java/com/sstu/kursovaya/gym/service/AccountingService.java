package com.sstu.kursovaya.gym.service;

import com.sstu.kursovaya.gym.model.Accounting;
import com.sstu.kursovaya.gym.model.utils.CreateAccountingRequest;

import java.util.List;

public interface AccountingService {
    void create(Accounting accounting);
    void delete(int id);
    Accounting get(int id);
    List<Accounting> getByClient(int id);
    List<Accounting> getAll();
}
