package com.sstu.kursovaya.gym.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Gender {
    private int id;
    private String type;
}
