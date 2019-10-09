package com.demo.zcxm.product.service;

import com.demo.zcxm.product.service.bo.Products;

import java.util.List;

/**
 * @Author: 刘旭
 * Date: 2019/10/8 15:49
 * @Version 1.0
 */
public interface IProductService {
    public List<Products> loadAllProducts();
    public Products loadProductById(Integer productId);
    public void addOrder(String yonghuName,Integer productId1);
    public List<Products> selectProductsByUserId(String yonghuName);
    public void deleteOrder(int productId,String userName);
}

