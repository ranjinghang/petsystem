package com.example.pet.dao;

import com.example.pet.bean.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @version V1.0.0
 * @date
 * @description 类注释
 */
@Repository
public interface PetDao extends JpaRepository<Pet, Long> {
}
