package com.example.pet.controller;

import com.example.pet.bean.Dogorder;
import com.example.pet.bean.Jy;
import com.example.pet.bean.VO.JyListVO;
import com.example.pet.bean.VO.OrderVO;
import com.example.pet.bean.util.BeanUtil;
import com.example.pet.dao.DogorderDao;
import com.example.pet.service.DogorderService;
import com.example.pet.service.JyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author
 * @version V1.0.0
 * @date
 * @description 类注释
 * @Copyright All rights reserved.
 */
@Controller
public class JyController {
    @Autowired
    private JyService jyService;
    @Autowired
    private DogorderService dogorderService;

    @RequestMapping(value = "/Jy/insert", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> jy(@RequestParam("orderNo") String orderNo){
        Jy jy = new Jy();
        jy.setOrderNo(Long.valueOf(orderNo));
        jy.setStatus(0);
        jy.setAgree(0);
        jyService.insertOne(jy);

        HashMap hashMap = new HashMap();
        hashMap.put("msg", "申请成功");
        return hashMap;
    }

    @RequestMapping("/jy/listView")
    public String jyListView(Model model) throws InstantiationException, IllegalAccessException {
        List<Map<String, Object>> jyListVOList =jyService.getJyListByAdminId();
        List<JyListVO> jyListVOS = BeanUtil.toList(jyListVOList, JyListVO.class);
        model.addAttribute("jyListVOList", jyListVOS);
        return "admin_jy_list";
    }

    @RequestMapping("/jy/agree")
    @ResponseBody
    private Map<String, Object> jyAgree(Model model, @RequestParam("jyId") Long jyId){
        Jy jy = jyService.getOne(jyId);
        jy.setAgree(1);

        jyService.insertOne(jy);

        HashMap hashMap = new HashMap();
        hashMap.put("msg", "已同意");
        return hashMap;
    }
}
