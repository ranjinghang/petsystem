package com.example.pet.controller;

import com.example.pet.bean.Dogorder;
import com.example.pet.bean.Jy;
import com.example.pet.dao.DogorderDao;
import com.example.pet.service.DogorderService;
import com.example.pet.service.JyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ranjinghang@haier.com
 * @version V1.0.0
 * @date
 * @description 类注释
 * @Copyright www.haiermoney.comInc. All rights reserved.
 */
@Controller
public class JyController {
    @Autowired
    private JyService jyService;
    @Autowired
    private DogorderService dogorderService;

    @RequestMapping("/Jy/insert?{orderNo}")
    public String jy(@PathVariable("orderNo") Long orderNo){
        Jy jy = new Jy();
        jy.setOrderNo(orderNo);
        jy.setStatus(0);
        jy.setAgree(0);
        jyService.insertOne(jy);

        return "申请成功";
    }
}
