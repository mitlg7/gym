package com.sstu.kursovaya.gym.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class Accounting {
    private int id;
    private Date start;
    private Date end;
    private Client client;
    private Subscription subscription;
}
