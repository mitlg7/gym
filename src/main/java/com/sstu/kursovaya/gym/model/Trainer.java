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
    private String image;
    private Position position;
    private Date birthday;
    private Gender gender;
    public Character getLettersGender(){
        return gender.getType().toCharArray()[0];
    }
}
