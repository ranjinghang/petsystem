package com.example.pet.service;

import com.example.pet.dao.DogorderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version V1.0.0
 * @date
 * @description 类注释
 */
@Service
public class DogorderService {
    @Autowired
    private DogorderDao dogorderDao;
}
