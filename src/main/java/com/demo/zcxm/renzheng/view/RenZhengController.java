package com.demo.zcxm.renzheng.view;

import com.demo.zcxm.renzheng.service.IRenZhengService;
import com.demo.zcxm.renzheng.service.bo.RenZheng;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: 刘旭
 * Date: 2019/10/9 23:31
 * @Version 1.0
 */
@Controller
@RequestMapping("/renZheng")
public class RenZhengController {
    private static final Logger logger= LogManager.getLogger(RenZhengController.class);
    @Autowired
    private IRenZhengService renZhengService;
    @RequestMapping("/addRenZhengInfo")
    public String addRenZheng(RenZheng renZheng){
        logger.info("===================="+renZheng);
        renZhengService.addRenZheng(renZheng);
        return "apply-1";
    }
}
