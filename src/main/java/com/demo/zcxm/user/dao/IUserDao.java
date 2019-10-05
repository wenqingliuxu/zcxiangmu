package com.demo.zcxm.user.dao;

import com.demo.zcxm.user.service.bo.User;

/**
 * @AuthorName 刘旭
 * @DATE2019/9/2919:34
 */
public interface IUserDao {
//    添加用户
    public void insert(User user);
//    登录
    public User getUserByUserName(String userName);
}
