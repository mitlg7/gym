package com.sstu.kursovaya.gym.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.Date;

@Data
@Accessors(chain = true)
public class Client {
    private int id;
    private String firstName;
    private String lastname;
    private String phone;
    private String email;
    private String token;
    private Date birthday;
    private Date registration;
    private Gender gender;
    private boolean active;

}
