package com.sstu.kursovaya.gym.model.utils;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class CreateAccountingRequest {
    private Date start;
    private Date end;
    private int client_id;
    private int subscription_id;

}
