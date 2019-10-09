package com.demo.zcxm.user.view;

import com.demo.zcxm.role.service.IRoleService;
import com.demo.zcxm.role.view.RoleController;
import com.demo.zcxm.user.service.IUserService;
import com.demo.zcxm.user.service.bo.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @AuthorName 刘旭
 * @DATE2019/9/2919:39
 */
@Controller
@RequestMapping("/user")
@SessionAttributes("yonghuName")
public class UserController extends RoleController {
    private static final Logger logger = LogManager.getLogger(UserController.class);
    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;

    @RequestMapping("/viewname/{view}")
    public String view(@PathVariable String view) {
        return view;
    }

    @RequestMapping("/dengLu")
    public String denglu(User user, Integer userType, Model model, HttpSession session) {
        model.addAttribute("yonghuName",user.getUserName());
        if (!user.getUserName().isEmpty()) {
            String upwd = user.getUserPwd();
            User userReb = userService.getUserByUserName(user.getUserName());
            Integer userNameCount = userService.getUserNameCount(user.getUserName());
            if (userNameCount == 0) {
                model.addAttribute("msg", "用户名或密码错误");
                return "login";
            } else {
                int userId = userReb.getUserId();
                if (upwd.equals(userReb.getUserPwd())) {
                    if ((userType == 2) && (selectRid(userId).contains(14))) {
                        return "main";
                    } else {
                        return "member";
                    }
                } else {
                    model.addAttribute("msg", "用户名或密码错误");
                    return "login";
                }
            }
        } else {
            model.addAttribute("msn", "用户名不能为空");
            return "login";
        }
    }

    @RequestMapping("/register")
    public String register(User user, Model model) {
        if ((!user.getUserName().isEmpty()) && (!user.getUserPwd().isEmpty())&&(!user.getUserNc().isEmpty())&&(!user.getUserEmail().isEmpty())) {
            Integer userNameCount = userService.getUserNameCount(user.getUserName());
            if (userNameCount == 0) {
                model.addAttribute("yonghuName",user.getUserName());
                userService.register(user);
                return "member";
            } else {
                model.addAttribute("msh", "用户名已存在");
                return "reg";
            }
        } else {
            model.addAttribute("msh", "用户信息不完整");
            return "reg";
        }
    }

    @RequestMapping("/user")
    public String showUsers(@RequestParam(required=false,defaultValue = "1") int page,
                            @RequestParam(required = false,defaultValue = "5") int rows,
                            Model model){
        int maxPage=userService.calcMaxPage(rows);
        if(page<1){
            page=maxPage;
        }
        if(page>maxPage){
            page=1;
        }
        List<User> users = userService.loadAllUsers(page, rows);
        model.addAttribute("users",users);
        model.addAttribute("currentPage",page);
        model.addAttribute("maxPage",maxPage);
        return "user";
    }
    @RequestMapping("/add")
    public String addUser(User user,Model model){
        if ((!user.getUserName().isEmpty()) && (!user.getUserPwd().isEmpty())&&(!user.getUserNc().isEmpty())&&(!user.getUserEmail().isEmpty())) {
            Integer userNameCount = userService.getUserNameCount(user.getUserName());
            if (userNameCount == 0) {
                userService.register(user);
                return  "redirect:user";
            } else {
                model.addAttribute("msh", "用户名已存在");
                return "add";
            }
        } else {
            model.addAttribute("msh", "用户信息不完整");
            return "add";
        }
    }
    @RequestMapping("/deleteUsers")
    public String deleteUsers(@RequestParam("ids") List<Integer> ids){
        roleService.deleteRids(ids);
        userService.deleteUsers(ids);
        return "redirect:user";
    }
    @RequestMapping("/delete")
    public String delete(int userId){
        roleService.deleteRid(userId);
        userService.delete(userId);
        return "redirect:user";
    }
    @RequestMapping("/loadUserById")
    public String loadUserById(int userId,Model model){
        User user = userService.loadUserById(userId);
        model.addAttribute("user",user);
        return "edit";
    }
    @RequestMapping("/updateUser")
    public String updateUser(User user){
        userService.updateUser(user);
        return "redirect:user";
    }
    @RequestMapping("/fuzzyQuery")
    public String fuzzyQuery(String sql,Model model){
        logger.info("====================="+sql);
        List<User> users = userService.fuzzyQuery(sql);
        logger.info("++++++++++++++++++++++++++++"+users);
        model.addAttribute("users",users);
        return "user";
    }
}
