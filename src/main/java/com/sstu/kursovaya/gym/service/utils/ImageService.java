package com.sstu.kursovaya.gym.service.utils;

import org.springframework.web.multipart.MultipartFile;


public interface ImageService {
    public String saveImage(MultipartFile file);
}
