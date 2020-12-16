package com.example.pet.dao;

import com.example.pet.bean.Jy;
import com.example.pet.bean.VO.JyListVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @version V1.0.0
 * @date
 * @description 接口注释
 */
@Repository
public interface JyDao extends JpaRepository<Jy, Long> {

    @Query(value = "select jy_id,pet_name,pet_name,order_name,pet_special,num,create_time,‘status’ from jy,dogorder,pet where jy.order_no = dogorder.order_no and dogorder.pet_id = pet.pet_id",nativeQuery = true)
    List<JyListVO> jyViewList();
}
