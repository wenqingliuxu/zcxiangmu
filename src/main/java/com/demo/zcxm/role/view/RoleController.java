package com.demo.zcxm.role.view;

import com.demo.zcxm.role.service.IRoleService;
import com.demo.zcxm.role.service.bo.Role;
import com.demo.zcxm.user.view.UserController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
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
    @RequestMapping("/deleteRids")
    public void deleteRids(@RequestParam("ids") List<Integer> ids){
        roleService.deleteRids(ids);
    }
    @RequestMapping("/deleteRid")
    public void deleteRid(int userId){
        roleService.deleteRid(userId);
    }
    @RequestMapping("/assignRole")
    public String loadRoleByUserId(int userId, Model model, HttpSession session){
        session.setAttribute("userId",userId);
        List<Role> roles = roleService.loadRoleByUserId(userId);
        model.addAttribute("roles",roles);
        List<Role> roles1 = roleService.loadRoleByNoUserId(userId);
        model.addAttribute("roles1",roles1);
        return "assignRole";
    }
    @RequestMapping("/leftGo")
    public String addRid(@RequestParam("rid") List<Integer> rid,HttpSession session){
        Integer userId1 = (Integer) session.getAttribute("userId");
        roleService.addRid(userId1,rid);
        return "redirect:assignRole?userId="+userId1;
    }
    @RequestMapping("/rightGo")
    public String deleteRid(@RequestParam("rid") List<Integer> rid,HttpSession session){
        Integer userId1 = (Integer) session.getAttribute("userId");
        roleService.deleteRidByUserId(userId1,rid);
        return "redirect:assignRole?userId="+userId1;
    }
    @RequestMapping("/role")
    public String loadAllRole(Model model){
        List<Role> roles = roleService.selectAllRole();
        model.addAttribute("roles",roles);
        return "role";
    }
}
