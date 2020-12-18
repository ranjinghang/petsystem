package com.example.pet.controller;

import com.example.pet.bean.Dogorder;
import com.example.pet.bean.Login;
import com.example.pet.bean.VO.OrderVO;
import com.example.pet.bean.util.BeanUtil;
import com.example.pet.service.DogorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public String orderListView(Model model, HttpServletRequest httpServletRequest) throws InstantiationException, IllegalAccessException {

        Login user = (Login) httpServletRequest.getSession().getAttribute("user");
        List<Map<String, Object>> dogorderListHashMap = dogorderService.getOrderListVO(user.getUserId());
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
    @ResponseBody
    public Map<String, Object> orderEvaluate(Model model, @RequestParam("orderNo") Long orderNo, @RequestBody Map<String, Object> eva){
        Dogorder dogorder = dogorderService.getById(orderNo);
        dogorder.setEvaluate(eva.get("eva").toString());
        dogorderService.insertOrder(dogorder);

        HashMap hashMap = new HashMap();
        hashMap.put("msg", "评价成功");
        return hashMap;
    }

    @RequestMapping("/order/delete")
    public String orderDelete(Model model, @RequestParam("orderNo") Long orderNo,HttpServletRequest httpServletRequest) throws InstantiationException, IllegalAccessException {
        dogorderService.deleteById(orderNo);

        Login user = (Login) httpServletRequest.getSession().getAttribute("user");
        List<Map<String, Object>> dogorderListHashMap = dogorderService.getOrderListVO(user.getUserId());
        List<OrderVO> dogorderList = BeanUtil.toList(dogorderListHashMap, OrderVO.class);
        model.addAttribute("orderList",dogorderList);
        return "order_list";
    }
}
