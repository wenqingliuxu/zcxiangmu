package com.demo.zcxm.role.view;

import com.demo.zcxm.role.service.IRoleService;
import com.demo.zcxm.user.view.UserController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author: 刘旭
 * Date: 2019/10/6 14:13
 * @Version 1.0
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    private static final Logger logger = LogManager.getLogger(UserController.class);
    @Autowired
    private IRoleService roleService;
    @RequestMapping("/selectRid")
    public List<Integer> selectRid(Integer uId){
        List<Integer> integers = roleService.selectRidByUid(uId);
        return integers;
    }
}
