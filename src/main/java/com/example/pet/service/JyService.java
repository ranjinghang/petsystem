package com.example.pet.service;

import com.example.pet.bean.Jy;
import com.example.pet.dao.JyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ranjinghang@haier.com
 * @version V1.0.0
 * @date
 * @description 类注释
 * @Copyright www.haiermoney.comInc. All rights reserved.
 */
@Service
public class JyService {
    @Autowired
    private JyDao jyDao;

    public Jy insertOne(Jy jy){
        return jyDao.save(jy);
    }

    public List<Jy> getJyListByAdminId(){
        return jyDao.jyViewList();
    }
}
