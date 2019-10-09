package com.demo.zcxm.renzheng.service.bo;

/**
 * @Author: 刘旭
 * Date: 2019/10/9 23:26
 * @Version 1.0
 */
public class RenZheng {
    private int id;
    private String realName;
    private String IDnumber;
    private String iPhone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIDnumber() {
        return IDnumber;
    }

    public void setIDnumber(String IDnumber) {
        this.IDnumber = IDnumber;
    }

    public String getiPhone() {
        return iPhone;
    }

    public void setiPhone(String iPhone) {
        this.iPhone = iPhone;
    }

    @Override
    public String toString() {
        return "RenZheng{" +
                "id=" + id +
                ", realName='" + realName + '\'' +
                ", IDnumber='" + IDnumber + '\'' +
                ", iPhone='" + iPhone + '\'' +
                '}';
    }
}
