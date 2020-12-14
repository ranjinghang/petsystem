package com.example.pet.dao;

import com.example.pet.bean.Dogorder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author cranjinghang@haier.com
 * @version V1.0.0
 * @date
 * @description 接口注释
 * @Copyright www.haiermoney.comInc. All rights reserved.
 */
@Repository
public interface DogorderDao extends JpaRepository<Dogorder, Long> {

    Dogorder save(Dogorder dogorder);
}
