package com.velazco.velazco_back.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageStorageService {
    String store(MultipartFile image);

    void delete(String imagePath);

    void validateSize(MultipartFile image);
}
