package com.sstu.kursovaya.gym.model.utils;

import lombok.Data;

@Data
public class CreateSubRequest {
    private String name;
    private String price;
    private String continuance;
    private String hall;
    private String trainer;
}
