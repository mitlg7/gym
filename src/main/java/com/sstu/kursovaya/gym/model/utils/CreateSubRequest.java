package com.sstu.kursovaya.gym.model.utils;

import lombok.Data;

@Data
public class CreateSubRequest {
    private String name;
    private String price;
    private String continuance_id;
    private String hall_id;
    private String trainer_id;
}
