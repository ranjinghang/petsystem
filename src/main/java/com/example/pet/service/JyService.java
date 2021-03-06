package com.example.pet.service;

import com.example.pet.bean.Jy;
import com.example.pet.bean.VO.JyListVO;
import com.example.pet.dao.JyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author
 * @version V1.0.0
 * @date
 * @description 类注释
 * @Copyright All rights reserved.
 */
@Service
public class JyService {
    @Autowired
    private JyDao jyDao;

    public Jy getOne(Long jyId){
        return jyDao.getOne(jyId);
    }

    public Jy insertOne(Jy jy){
        return jyDao.save(jy);
    }

    public List<Map<String, Object>> getJyListByAdminId(){
        return jyDao.jyViewList();
    }
}
