package com.demo.zcxm.product.service.bo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author: 刘旭
 * Date: 2019/10/8 15:49
 * @Version 1.0
 */
public class Products {
    private int productId;
    private String productName;
    private String productImg;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date date;
    private Double targetPrice;
    private String productInfo;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getTargetPrice() {
        return targetPrice;
    }

    public void setTargetPrice(Double targetPrice) {
        this.targetPrice = targetPrice;
    }

    public String getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(String productInfo) {
        this.productInfo = productInfo;
    }

    @Override
    public String toString() {
        return "Products{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productImg='" + productImg + '\'' +
                ", date=" + date +
                ", targetPrice=" + targetPrice +
                ", productInfo='" + productInfo + '\'' +
                '}';
    }
}
