package com.example.pet.controller;

import com.example.pet.bean.Login;
import com.example.pet.bean.req.LoginReq;
import com.example.pet.service.LoginServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * @author
 * @version V1.0.0
 * @date
 * @description 类注释
 * @Copyright All rights reserved.
 */
@RestController
public class LoginController {
    @Autowired
    private LoginServcie loginServcie;

    @GetMapping("/index")
    public ModelAndView index(Model model){
        return new ModelAndView("index");
    }

    @RequestMapping(value = "login/logincheck", method = RequestMethod.POST, consumes = "application/json")
    public Object login(@RequestBody LoginReq loginReq, HttpServletRequest httpServletRequest) {
        HashMap<String, String> res = new HashMap<>();
        Login login = loginServcie.login(loginReq.getUserId(), loginReq.getPassword());
        if (login != null){
            if ("2".equals(login.getType())){
                httpServletRequest.getSession().setAttribute("admin", login);
                res.put("stateCode", "1");
                res.put("msg", "管理员登陆成功！");
            }else if("1".equals(login.getType())) {
                httpServletRequest.getSession().setAttribute("user", login);
                res.put("stateCode", "2");
                res.put("msg", "用户登陆成功！");
            }
        }else {
            res.put("stateCode", "0");
            res.put("msg", "账号或密码错误！");
        }

        return res;
    }

    @RequestMapping("/login/adminLogin")
    public ModelAndView toAdminMain(HttpServletResponse response) {
        return new ModelAndView("admin_main");
    }

    @RequestMapping("/login/userLogin")
    public ModelAndView toReaderMain(HttpServletResponse response) {
        return new ModelAndView("reader_main");
    }

    @RequestMapping("/reader_header.html")
    public ModelAndView readerHeader(HttpServletResponse response) {
        return new ModelAndView("reader_header");
    }

    @RequestMapping("/admin_header.html")
    public ModelAndView adminHeader(HttpServletResponse response) {
        return new ModelAndView("admin_header");
    }

}
