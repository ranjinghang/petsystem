package com.example.pet.dao;

import com.example.pet.bean.Jy;
import com.example.pet.bean.VO.JyListVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @version V1.0.0
 * @date
 * @description 接口注释
 */
@Repository
public interface JyDao extends JpaRepository<Jy, Long> {

    @Query(value = "select j_id AS jyId,pet_name AS petName,order_name AS orderName,pet_special AS petSpecial,num,create_time AS createTime, agree from jy,dogorder,pet where jy.order_no = dogorder.order_no and dogorder.pet_id = pet.pet_id",nativeQuery = true)
    List<Map<String, Object>> jyViewList();
}
