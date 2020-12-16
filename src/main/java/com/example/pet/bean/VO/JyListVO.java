package com.example.pet.bean.VO;

/**
 * @author ranjinghang@haier.com
 * @version V1.0.0
 * @date
 * @description 类注释
 * @Copyright www.haiermoney.comInc. All rights reserved.
 */
public class JyListVO {
    private Long jyId;
    private String petName;
    private String orderName;
    private String petSpecial;
    private int num;
    private String carateTime;
    private int status;

    public Long getJyId() {
        return jyId;
    }

    public void setJyId(Long jyId) {
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

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getCarateTime() {
        return carateTime;
    }

    public void setCarateTime(String carateTime) {
        this.carateTime = carateTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
