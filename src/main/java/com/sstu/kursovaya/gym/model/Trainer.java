package com.sstu.kursovaya.gym.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.Date;

@Data
@Accessors(chain = true)
public class Trainer {
    private int id;
    private String name;
    private String phone;
    private String position;
    private Date birthday;
    private String gender;
}
