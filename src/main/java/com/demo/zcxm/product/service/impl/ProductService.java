package com.demo.zcxm.product.service.impl;

import com.demo.zcxm.product.dao.IProductDao;
import com.demo.zcxm.product.service.IProductService;
import com.demo.zcxm.product.service.bo.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 刘旭
 * Date: 2019/10/8 15:50
 * @Version 1.0
 */
@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductDao productDao;

    @Override
    public List<Products> loadAllProducts() {
        List<Products> products = productDao.loadAllProducts();
        return products;
    }

    @Override
    public Products loadProductById(Integer productId) {
        Products product = productDao.loadProductById(productId);
        return product;
    }

    @Override
    public void addOrder(String yonghuName, Integer productId1) {
        productDao.addOrder(yonghuName,productId1);
    }

    @Override
    public List<Products> selectProductsByUserId(String yonghuName) {
        List<Products> productsList = productDao.selectProductsByUserId(yonghuName);
        return productsList;
    }

    @Override
    public void deleteOrder(int productId,String userName) {
        productDao.deleteOrder(productId,userName);
    }
}
