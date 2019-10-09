package com.demo.zcxm.product.dao;

import com.demo.zcxm.product.service.bo.Products;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: 刘旭
 * Date: 2019/10/8 15:49
 * @Version 1.0
 */
public interface IProductDao {
    public List<Products> loadAllProducts();
    public Products loadProductById(Integer productId);
    public void addOrder(@Param("userName") String yonghuName,@Param("productId")Integer productId1);
    public List<Products> selectProductsByUserId(@Param("userName")String yonghuName);
    public void deleteOrder(int productId,@Param("userName")String userName);
}
