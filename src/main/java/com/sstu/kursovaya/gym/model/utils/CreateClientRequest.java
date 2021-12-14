package com.sstu.kursovaya.gym.model.utils;

import lombok.Data;

@Data
public class CreateClientRequest {
    private String name;
    private String lastname;
    private String phone;
    private String birthday;
    private String email;
    private String gender;
}
