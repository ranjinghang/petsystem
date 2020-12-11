package com.example.pet.service;

import com.example.pet.bean.Login;
import com.example.pet.dao.LoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ranjinghang@haier.com
 * @version V1.0.0
 * @date
 * @description 类注释
 * @Copyright www.haiermoney.comInc. All rights reserved.
 */
@Service
public class LoginServcie {
    @Autowired
    private LoginDao loginDao;

    public Login login(String id, String password){
        Login login = loginDao.getByUserIdAndPw(id, password);
        return login;
    }
}
