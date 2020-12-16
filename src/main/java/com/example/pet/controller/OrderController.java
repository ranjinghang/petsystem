package com.example.pet.controller;

import com.example.pet.bean.Dogorder;
import com.example.pet.bean.VO.OrderVO;
import com.example.pet.service.DogorderService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author ranjinghang@haier.com
 * @version V1.0.0
 * @date
 * @description 类注释
 * @Copyright www.haiermoney.comInc. All rights reserved.
 */
@Controller
public class OrderController {
    @Autowired
    private DogorderService dogorderService;

    @RequestMapping("/order/listView")
    public String orderListView(Model model){
        List<OrderVO> dogorderList = dogorderService.getOrderListVO();

        model.addAttribute("orderList",dogorderList);
        return "order_list";
    }

    @RequestMapping("/order/evaluateView?{orderNo}")
    public String orderEvaluateView(Model model, @PathVariable("orderNo") Long orderNo){
        model.addAttribute("orderNo", orderNo);
        return "order_evaluateView";
    }

    @RequestMapping(value = "/order/evaluate?{orderNo}", method = RequestMethod.POST)
    public String orderEvaluate(Model model, @PathVariable("orderNo") Long orderNo, @RequestBody String eva){
        Dogorder dogorder = dogorderService.getById(orderNo);
        dogorder.setEvaluate(eva);
        dogorderService.insertOrder(dogorder);

        return "评价成功";
    }

    @RequestMapping("/order/delete?{orderNo}")
    public String orderDelete(Model model, @PathVariable("orderNo") Long orderNo){
        dogorderService.deleteById(orderNo);

        return "删除成功";
    }
}
