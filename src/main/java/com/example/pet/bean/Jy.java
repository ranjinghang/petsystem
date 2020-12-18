package com.example.pet.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @version V1.0.0
 * @date
 * @description 类注释
 */
@Entity
@Table(name = "jy")
public class Jy {
    @Id
    @GeneratedValue()
    private Long jId;
    private Long orderNo;
    private int status;
    private int agree;

    public Long getjId() {
        return jId;
    }

    public void setjId(Long jId) {
        this.jId = jId;
    }

    public Long getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Long orderNo) {
        this.orderNo = orderNo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getAgree() {
        return agree;
    }

    public void setAgree(int agree) {
        this.agree = agree;
    }
}
