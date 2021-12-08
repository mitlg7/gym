package com.sstu.kursovaya.gym.model.utils;

import lombok.Data;

@Data
public class CreateTrainerRequest {
    private String name;
    private String phone;
    private String birthday;
    private String gender;
    private String position;
}
