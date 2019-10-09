package com.demo.zcxm.product.view;

import com.demo.zcxm.product.service.IProductService;
import com.demo.zcxm.product.service.bo.Products;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author: 刘旭
 * Date: 2019/10/8 15:49
 * @Version 1.0
 */
@Controller
@RequestMapping("/product")
//@SessionAttributes("productId")
public class ProductController {
    private static final Logger logger = LogManager.getLogger(ProductController.class);
    @Autowired
    private IProductService productService;

    @RequestMapping("/products")
    public String loadAllProducts(Model model) {
        List<Products> products = productService.loadAllProducts();
        model.addAttribute("products", products);
        return "projects";
    }
    @RequestMapping("/project")
    public String loadProductById(int productId, Model model, HttpSession session){
        Products product = productService.loadProductById(productId);
        session.setAttribute("productId",productId);
        model.addAttribute("product",product);
        return "project";
    }
    @RequestMapping("/pay-step-1")
    public String loadProduct(Integer productId,Model model,HttpSession session){
        Integer productId1 = (Integer) session.getAttribute("productId");
        Products product = productService.loadProductById(productId1);
        model.addAttribute("product",product);
        return "pay-step-1";
    }
    @RequestMapping("/goLogin")
    public String goLogin(Integer productId,HttpSession session,Model model){
        Integer productId1 = (Integer) session.getAttribute("productId");
        Products product = productService.loadProductById(productId1);
        model.addAttribute("product",product);
        return "login";
    }
    @RequestMapping("/minecrowdfunding")
    public String myZhongChou(Integer productId,String userName,HttpSession session,Model model){
        Integer productId1 = (Integer) session.getAttribute("productId");
        String  yonghuName = (String) session.getAttribute("yonghuName");
        model.addAttribute("yonghuName",yonghuName);
        productService.addOrder(yonghuName,productId1);
        List<Products> productsList = productService.selectProductsByUserId(yonghuName);
        model.addAttribute("productsList",productsList);
        return "minecrowdfunding";
    }
    @RequestMapping("/DeleteOrder")
    public String deleteOrder(int productId, String userName, HttpSession session, Model model){
        logger.info("===========================productId:"+productId);
        String  yonghuName = (String) session.getAttribute("yonghuName");
        logger.info("===========================yonghuName:"+yonghuName);
        productService.deleteOrder(productId,userName);
        List<Products> productsList = productService.selectProductsByUserId(yonghuName);
        model.addAttribute("productsList",productsList);
        return "redirect:minecrowdfunding";
    }
}
