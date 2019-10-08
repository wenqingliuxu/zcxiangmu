package com.demo.zcxm.permission.view;

import com.demo.zcxm.permission.service.IPermissionService;
import com.demo.zcxm.permission.service.bo.Permission;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 刘旭
 * Date: 2019/10/8 8:58
 * @Version 1.0
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {
    private static final Logger logger= LogManager.getLogger(PermissionController.class);
    @Autowired
    private IPermissionService permissionService;

    @RequestMapping("/loadAllPermission")
    public String loadAllPermission(){
        return "permission";
    }

    @ResponseBody
    @RequestMapping("/loadPermissionAll")
    public List<Permission> loadPermissionAll() {
        return permissionService.loadAll();
    }

    @RequestMapping("/loadPermission")
    public String loadPermissions(int roleId, Model model) {
        model.addAttribute("roleId", roleId);
        return "assignPermission";
    }

    @ResponseBody
    @RequestMapping("/loadPermissionByRoleId")
    public List<Permission> loadPermissionByRoleId(int roleId, Model model) {
        model.addAttribute("roleId", roleId);
        List<Permission> allList = permissionService.loadAll();
        List<Permission> roleList = permissionService.loadPmsByRoleId(roleId);
        logger.info("============================allList："+allList);
        logger.info("============================roleList："+roleList);
        for (Permission rolePermission : roleList) {
            for (Permission allPermission : allList) {
                if (rolePermission.getId() == allPermission.getId()) {
                    allPermission.setChecked("true");
                    break;
                }
            }
        }
        return allList;
    }

    @ResponseBody
    @RequestMapping("/assignpermission")
    public boolean assignPermission(String pids, int roleId) {
        String[] ps = pids.split("-");
        System.out.println(ps);
        List<Integer> list = new ArrayList<>();
        for (String p : ps) {
            list.add(Integer.parseInt(p));
        }
        boolean a = permissionService.deletePms(roleId);
        boolean b = permissionService.addPms(roleId, list);
        return b ? true : false;
    }
}
