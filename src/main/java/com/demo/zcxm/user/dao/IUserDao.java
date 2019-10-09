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
    public List<User> loadAllUsers(int page,int rows);
//    批量删除用户
    public void deleteUsers(List<Integer> ids);
//    根据Id删除用户
    public void delete(int userId);
//    根据ID查询用户
    public User loadUserById(int userId);
//    更新用户信息
    public void updateUser(User user);
//    模糊查询
    public List<User> fuzzyQuery(String sql);
//    查询最大用户Id
    public int getMaxUserId();
//    获取总行数
    public int getTotalCount();
//    计算最大页数
    public int calcMaxPage(int rows);
//    根据用户名查询用户Id
    public int getUserId(String userName);
}
