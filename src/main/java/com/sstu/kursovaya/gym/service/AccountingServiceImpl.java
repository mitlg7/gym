package com.sstu.kursovaya.gym.service;

import com.sstu.kursovaya.gym.model.Accounting;
import com.sstu.kursovaya.gym.model.utils.CreateAccountingRequest;
import com.sstu.kursovaya.gym.repository.AccountingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class AccountingServiceImpl implements AccountingService {
    @Autowired
    AccountingRepository accountingRepository;

    @Override
    public void create(Accounting accounting) {
        accountingRepository.create(accounting);
    }

    @Override
    public void delete(int id) {
        accountingRepository.delete(id);
    }

    @Override
    public Accounting get(int id) {
        return accountingRepository.get(id);
    }

    @Override
    public List<Accounting> getByClient(int id) {
        return accountingRepository.getByClient(id);
    }

    @Override
    public List<Accounting> getAll() {
        return accountingRepository.getAll();
    }
}
