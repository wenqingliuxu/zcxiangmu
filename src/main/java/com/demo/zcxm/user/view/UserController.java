package com.demo.zcxm.user.view;

import com.demo.zcxm.user.service.IUserService;
import com.demo.zcxm.user.service.bo.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @AuthorName 刘旭
 * @DATE2019/9/2919:39
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private static final Logger logger= LogManager.getLogger(UserController.class);
    @Autowired
    private IUserService userService;
    @RequestMapping("/viewname/{view}")
    public String view(@PathVariable String view){
        return view;
         }
    @RequestMapping("/dengLu")
    public String denglu(User user){
        String upwd=user.getUserPwd();
        User userReb = userService.getUserByUserName(user.getUserName());
        if(upwd.equals(userReb.getUserPwd())) {
            return "member";
        }
        else {
            return "login";
        }
    }
}
