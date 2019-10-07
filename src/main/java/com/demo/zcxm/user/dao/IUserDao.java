package com.demo.zcxm.user.dao;

import com.demo.zcxm.user.service.bo.User;

import java.util.List;

/**
 * @AuthorName 刘旭
 * @DATE2019/9/2919:34
 */
public interface IUserDao {
//    添加用户
    public void insert(User user);
//    登录
    public User getUserByUserName(String userName);
//    查询用户名是否存在
    public Integer getUserNameCount(String userName);
//    查询所有用户信息
    public List<User> loadAllUsers();
//    批量删除用户
    public void deleteUsers(List<Integer> ids);
//    根据Id删除用户
    public void delete(int userId);
//    根据ID查询用户
    public User loadUserById(int userId);
//    更新用户信息
    public void updateUser(User user);
}
