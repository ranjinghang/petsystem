package com.example.pet.controller;

import com.example.pet.bean.Dogorder;
import com.example.pet.bean.Jy;
import com.example.pet.bean.VO.JyListVO;
import com.example.pet.dao.DogorderDao;
import com.example.pet.service.DogorderService;
import com.example.pet.service.JyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

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

    @RequestMapping("/jy/listView")
    public String jyListView(Model model){
        List<JyListVO> jyListVOList = new ArrayList<>();
        jyListVOList = jyService.getJyListByAdminId();
        model.addAttribute("jyListVOList", jyListVOList);
        return "admin_jy_list";
    }

    @RequestMapping("/jy/agree?{jyId}")
    private String jyAgree(Model model, @PathVariable("jyId") Long jyId){
        Jy jy = new Jy();
        jy.setjId(jyId);
        jy.setAgree(1);

        jy = jyService.insertOne(jy);

        return "修改成功";
    }
}
