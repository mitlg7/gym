package com.sstu.kursovaya.gym.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.Date;

@Data
@Accessors(chain = true)
public class Client {
    private Long id;
    private String name;
    private String lastname;
    private String phone;
    private Date birthday;
    private Date registration;
    private String gender;
    private Role role;

}
