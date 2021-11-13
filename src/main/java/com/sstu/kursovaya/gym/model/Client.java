package com.sstu.kursovaya.gym.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Client {
    private Long id;
    private String name;
    private String lastname;
    private String phone;
    private String birthday;
    private String gender;
    private Role role;

}
