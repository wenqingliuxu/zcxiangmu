package com.demo.zcxm.user.view;

import com.demo.zcxm.role.view.RoleController;
import com.demo.zcxm.user.service.IUserService;
import com.demo.zcxm.user.service.bo.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @AuthorName 刘旭
 * @DATE2019/9/2919:39
 */
@Controller
@RequestMapping("/user")
public class UserController extends RoleController {
    private static final Logger logger = LogManager.getLogger(UserController.class);
    @Autowired
    private IUserService userService;

    @RequestMapping("/viewname/{view}")
    public String view(@PathVariable String view) {
        return view;
    }

    @RequestMapping("/dengLu")
    public String denglu(User user, Integer userType, Model model, HttpSession session) {
        if (!user.getUserName().isEmpty()) {
            String upwd = user.getUserPwd();
            User userReb = userService.getUserByUserName(user.getUserName());
            int userId = userReb.getUserId();
            if (userReb != null) {
                if (upwd.equals(userReb.getUserPwd())) {

                    if ((userType==2)&&(selectRid(userId).contains(14))) {
                        return "main";
                    } else {
                        return "member";
                    }
                } else {
                    model.addAttribute("msg", "用户名或密码错误");
                    return "login";
                }
            } else {
                model.addAttribute("msg", "用户名或密码错误");
                return "login";
            }
        } else {
            model.addAttribute("msn", "用户名不能为空");
            return "login";
        }
    }
}
