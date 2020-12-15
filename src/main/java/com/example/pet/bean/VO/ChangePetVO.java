package com.example.pet.bean.VO;

/**
 * @author ranjinghang@haier.com
 * @version V1.0.0
 * @date
 * @description 类注释
 * @Copyright www.haiermoney.comInc. All rights reserved.
 */
public class ChangePetVO {
    private String petName;
    private String petSpeical;
    private String price;

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getPetSpeical() {
        return petSpeical;
    }

    public void setPetSpeical(String petSpeical) {
        this.petSpeical = petSpeical;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
