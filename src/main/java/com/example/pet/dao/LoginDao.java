package com.example.pet.dao;

import com.example.pet.bean.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @version V1.0.0
 * @date
 * @description 接口注释
 */
@Repository
public interface LoginDao extends JpaRepository<Login, String> {

    Login getByUserIdAndPw(String userId, String pw);
}
