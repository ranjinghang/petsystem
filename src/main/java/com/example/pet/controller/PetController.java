package com.example.pet.controller;
import java.math.BigDecimal;

import com.example.pet.bean.Dogorder;
import com.example.pet.bean.Pet;
import com.example.pet.bean.VO.PetBuyVO;
import com.example.pet.service.DogorderService;
import com.example.pet.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
 * @author ranjinghang@haier.com
 * @version V1.0.0
 * @date
 * @description 类注释
 * @Copyright www.haiermoney.comInc. All rights reserved.
 */
@Controller
public class PetController {
    @Autowired
    private PetService petService;
    @Autowired
    private DogorderService dogorderService;

    @RequestMapping("/pet/listView")
    public String getPetListView(Model model){
        List<Pet> petList = petService.getAllPet();

        model.addAttribute("petList",petList);
        return "pet_list";
    }

    @RequestMapping("/pet/buyView?{petId}")
    public String getPetBuyView(Model model, @PathVariable("petId") Long petId){
        model.addAttribute("petId",petId);
        return "pet_list";
    }

    @RequestMapping(value = "/pet/buy?{petId}", method = RequestMethod.POST)
    public String petBuy(@PathVariable("petId") Long petId,@RequestBody PetBuyVO petBuyVO){
        Dogorder dogorder = new Dogorder();
        dogorder.setOrderName("购买订单");
        dogorder.setUserId("");
        dogorder.setPetId(petId.toString());
        dogorder.setPetId(petBuyVO.getPetId().toString());
        String format = "YYYY-MM-dd hh:mm:ss";
        dogorder.setCreateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern(format)));
        dogorder.setAmount(new BigDecimal(petBuyVO.getCount()));
        dogorder.setNum(petBuyVO.getCount());

        dogorderService.insertOrder(dogorder);

        return "购买成功";
    }

}
