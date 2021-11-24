package com.sstu.kursovaya.gym.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Subscription {
    private Long id;
    private Long price;
    private String name;
    private Trainer trainer;
    private Hall hall;
}
