package com.sstu.kursovaya.gym.model.utils;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class CreateTrainerRequest {
    private String name;
    private String phone;
    private String birthday;
    private String gender;
    private String position;
    MultipartFile image;
}
