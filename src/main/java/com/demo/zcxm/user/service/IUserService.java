package com.demo.zcxm.user.service;

import com.demo.zcxm.user.service.bo.User;

/**
 * @AuthorName 刘旭
 * @DATE2019/9/2917:37
 */
public interface IUserService {
    public void register(User user);
    public User getUserByUserName(String userName);
}
