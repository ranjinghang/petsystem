package com.example.pet.service;

import com.example.pet.bean.Dogorder;
import com.example.pet.bean.VO.OrderVO;
import com.example.pet.dao.DogorderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version V1.0.0
 * @date
 * @description 类注释
 */
@Service
public class DogorderService {
    @Autowired
    private DogorderDao dogorderDao;

    public Dogorder insertOrder(Dogorder dogorder){
        return dogorderDao.save(dogorder);
    }

    public List<Dogorder> getAllOrder(){
        return dogorderDao.findAll();
    }

    public Dogorder getById(Long orderNo){
        return dogorderDao.getOne(orderNo);
    }

    public void deleteById(Long orderNo){
        dogorderDao.deleteById(orderNo);
    }

    public List<Map<String, Object>> getOrderListVO(String userId){
        return dogorderDao.getOrderListVO(userId);
    }
}
