package com.example.pet.dao;

import com.example.pet.bean.Dogorder;
import com.example.pet.bean.VO.OrderVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author
 * @version V1.0.0
 * @date
 * @description 接口注释
 * @Copyright  All rights reserved.
 */
@Repository
public interface DogorderDao extends JpaRepository<Dogorder, Long> {

    Dogorder save(Dogorder dogorder);

    @Query(value = "SELECT dogorder.order_name AS orderName," +
            "dogorder.create_time AS createTime," +
            "dogorder.num AS num," +
            "dogorder.evaluate AS evaluate," +
            "dogorder.order_no AS orderNo," +
            "jy.j_id AS jyId," +
            "jy.`status` AS `status`," +
            "jy.agree AS agree " +
            "FROM "+
            "dogorder " +
            "INNER JOIN jy " +
            "WHERE dogorder.order_no = jy.order_no",nativeQuery = true)
    List<Map<String,Object>> getOrderListVO();
}
