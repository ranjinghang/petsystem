package com.example.pet.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

/**
 * @author ranjinghang@haier.com
 * @version V1.0.0
 * @date \
 * @description 类注释
 * @Copyright www.haiermoney.comInc. All rights reserved.
 */
@RestController
public class JspController {
    @RequestMapping("/admin_main.html")
    public ModelAndView toAdminMain(HttpServletResponse response){
        return new ModelAndView("admin_main");
    }
}
