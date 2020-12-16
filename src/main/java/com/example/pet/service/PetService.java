package com.example.pet.service;

import com.example.pet.bean.Pet;
import com.example.pet.dao.PetDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author
 * @version V1.0.0
 * @date
 * @description 类注释
 * @Copyright All rights reserved.
 */
@Service
public class PetService {
    @Autowired
    private PetDao petDao;

    public List<Pet> getAllPet(){
        return petDao.findAll();
    }

    public Pet getById(Long petId){
        return petDao.getOne(petId);
    }

    public Pet save(Pet pet) {
        return petDao.save(pet);
    }
}
