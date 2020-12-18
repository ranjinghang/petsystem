package com.example.pet.controller;
import java.math.BigDecimal;

import com.example.pet.bean.Dogorder;
import com.example.pet.bean.Pet;
import com.example.pet.bean.VO.ChangePetVO;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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
public class PetController {
    @Autowired
    private PetService petService;
    @Autowired
    private DogorderService dogorderService;

    @RequestMapping("/pet/listView")
    public String getPetListView(Model model, @RequestParam("type") int type){
        List<Pet> petList = petService.getAllPet();
        model.addAttribute("petList",petList);
        if (type == 1){
            return "admin_pet_list";
        }

        return "pet_list";
    }

    @RequestMapping("/pet/buyView")
    public String getPetBuyView(Model model, @RequestParam("petId") Long petId){
        model.addAttribute("petId",petId);
        return "pet_buy";
    }

    @RequestMapping(value = "/pet/buy", method = RequestMethod.POST)
    public Map<String, Object> petBuy(@RequestParam("petId") Long petId, @RequestBody PetBuyVO petBuyVO){
        Dogorder dogorder = new Dogorder();
        dogorder.setOrderName("购买订单");
        dogorder.setUserId("");
        dogorder.setPetId(petId.toString());
        Pet pet = petService.getById(petId);
        String format = "YYYY-MM-dd hh:mm:ss";
        dogorder.setCreateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern(format)));
        dogorder.setAmount(new BigDecimal(petBuyVO.getCount()).multiply(new BigDecimal(Double.valueOf(pet.getPetPrice()))));
        dogorder.setNum(petBuyVO.getCount());

        dogorderService.insertOrder(dogorder);

        HashMap hashMap = new HashMap();
        hashMap.put("msg", "购买成功");
        return hashMap;
    }

    @RequestMapping("/pet/changeView")
    public String getPetChangeView(Model model, @RequestParam("petId") Long petId){
        model.addAttribute("petId",petId);
        return "admin_pet_change";
    }

    @RequestMapping(value = "/pet/changeView", method = RequestMethod.POST)
    public String changePet(Model model, @RequestBody ChangePetVO changePetVO, @RequestParam("petId") Long petId){
        Pet pet = new Pet();
        pet.setPetId(petId);
        pet.setPetName(changePetVO.getPetName());
        pet.setPetSpecial(changePetVO.getPetSpeical());
        pet.setPetPrice(changePetVO.getPrice());

        petService.save(pet);
        return "修改成功";
    }

    @RequestMapping("/pet/addView")
    public String getPetAddView(Model model){
        return "admin_pet_add";
    }

    @RequestMapping(value = "/pet/add", method = RequestMethod.POST)
    public String petAdd(Model model, @RequestBody ChangePetVO changePetVO){
        Pet pet = new Pet();
        pet.setPetName(changePetVO.getPetName());
        pet.setPetSpecial(changePetVO.getPetSpeical());
        pet.setPetPrice(changePetVO.getPrice());
        pet.setAdminId("");

        return "添加成功";
    }
}
