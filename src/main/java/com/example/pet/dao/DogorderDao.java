package com.example.pet.dao;

import com.example.pet.bean.Dogorder;
import com.example.pet.bean.VO.OrderVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author cranjinghang@haier.com
 * @version V1.0.0
 * @date
 * @description 接口注释
 * @Copyright www.haiermoney.comInc. All rights reserved.
 */
@Repository
public interface DogorderDao extends JpaRepository<Dogorder, Long> {

    Dogorder save(Dogorder dogorder);

    @Query(value = "SELECT\n" +
            "\tdogorder.order_name, \n" +
            "\tdogorder.create_time, \n" +
            "\tdogorder.num, \n" +
            "\tdogorder.evaluate, \n" +
            "\tjy.j_id, \n" +
            "\tjy.`status`, \n" +
            "\tjy.agree\n" +
            "FROM\n" +
            "\tdogorder\n" +
            "\tINNER JOIN\n" +
            "\tjy\n" +
            "WHERE\n" +
            "\tdogorder.order_no = jy.order_no",nativeQuery = true)
    List<OrderVO> getOrderListVO();
}
