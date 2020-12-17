package com.example.pet.bean.VO;

import java.math.BigInteger;

/**
 * @author
 * @version V1.0.0
 * @date
 * @description 类注释
 * @Copyright All rights reserved.
 */
public class OrderVO {
    private String orderName;
    private String createTime;
    private Integer num;
    private String evaluate;
    private BigInteger orderNo;
    private BigInteger jyId;
    private Integer status;
    private Integer agree;

    public OrderVO() {
    }

    public OrderVO(String orderName, String createTime, Integer num, String evaluate, BigInteger orderNo, BigInteger jyId, int status, int agree) {
        this.orderName = orderName;
        this.createTime = createTime;
        this.num = num;
        this.evaluate = evaluate;
        this.orderNo = orderNo;
        this.jyId = jyId;
        this.status = status;
        this.agree = agree;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }

    public BigInteger getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(BigInteger orderNo) {
        this.orderNo = orderNo;
    }

    public BigInteger getJyId() {
        return jyId;
    }

    public void setJyId(BigInteger jyId) {
        this.jyId = jyId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getAgree() {
        return agree;
    }

    public void setAgree(Integer agree) {
        this.agree = agree;
    }
}
