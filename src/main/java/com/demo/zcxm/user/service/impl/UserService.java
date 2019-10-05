package com.demo.zcxm.user.service.impl;

import com.demo.zcxm.user.dao.IUserDao;
import com.demo.zcxm.user.service.IUserService;
import com.demo.zcxm.user.service.IUserService;
import com.demo.zcxm.user.service.bo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @AuthorName 刘旭
 * @DATE2019/9/2917:37
 */
@Service
public class UserService implements IUserService {
    @Autowired
    private IUserDao userDao;
    @Override
    public void register(User user) {
        userDao.insert(user);
    }

    @Override
    public User getUserByUserName(String userName) {
        return userDao.getUserByUserName(userName);
    }


}
