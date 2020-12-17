package com.example.pet.controller;

import com.example.pet.bean.Dogorder;
import com.example.pet.bean.VO.OrderVO;
import com.example.pet.bean.util.BeanUtil;
import com.example.pet.service.DogorderService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author
 * @version V1.0.0
 * @date
 * @description 类注释
 * @Copyright  All rights reserved.
 */
@Controller
public class OrderController {
    @Autowired
    private DogorderService dogorderService;

    @RequestMapping("/order/listView")
    public String orderListView(Model model) throws InstantiationException, IllegalAccessException {
        List<Map<String, Object>> dogorderListHashMap = dogorderService.getOrderListVO();
        //List<OrderVO> dogorderList = dogorderListHashMap.stream().map(map -> new OrderVO(map.get("orderName"), map.get("createTime"), map.get("num"), map.get("evaluate"), map.get("orderNo"), map.get("jyId"), map.get("status"), map.get("agree"))).collect(Collectors.toList());
        List<OrderVO> dogorderList = BeanUtil.toList(dogorderListHashMap, OrderVO.class);

        model.addAttribute("orderList",dogorderList);
        return "order_list";
    }

    @RequestMapping("/order/evaluateView")
    public String orderEvaluateView(Model model, @RequestParam("orderNo") Long orderNo){
        model.addAttribute("orderNo", orderNo);
        return "order_evaluateView";
    }

    @RequestMapping(value = "/order/evaluate", method = RequestMethod.POST)
    public String orderEvaluate(Model model, @RequestParam("orderNo") Long orderNo, @RequestBody String eva){
        Dogorder dogorder = dogorderService.getById(orderNo);
        dogorder.setEvaluate(eva);
        dogorderService.insertOrder(dogorder);

        return "评价成功";
    }

    @RequestMapping("/order/delete")
    public String orderDelete(Model model, @RequestParam("orderNo") Long orderNo){
        dogorderService.deleteById(orderNo);

        return "删除成功";
    }
}
