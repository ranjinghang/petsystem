package com.example.pet.bean.VO;

import java.math.BigInteger;

/**
 * @author
 * @version V1.0.0
 * @date
 * @description 类注释
 * @Copyright All rights reserved.
 */
public class JyListVO {
    private BigInteger jyId;
    private String petName;
    private String orderName;
    private String petSpecial;
    private Integer num;
    private String createTime;
    private Integer agree;

    public BigInteger getJyId() {
        return jyId;
    }

    public void setJyId(BigInteger jyId) {
        this.jyId = jyId;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getPetSpecial() {
        return petSpecial;
    }

    public void setPetSpecial(String petSpecial) {
        this.petSpecial = petSpecial;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getAgree() {
        return agree;
    }

    public void setAgree(Integer agree) {
        this.agree = agree;
    }
}
