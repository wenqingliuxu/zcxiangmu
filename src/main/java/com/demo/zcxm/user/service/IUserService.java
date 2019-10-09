package com.demo.zcxm.user.service;

import com.demo.zcxm.user.service.bo.User;

import java.util.List;

/**
 * @AuthorName 刘旭
 * @DATE2019/9/2917:37
 */
public interface IUserService {
    public void register(User user);
    public User getUserByUserName(String userName);
    public Integer getUserNameCount(String userName);
    public List<User> loadAllUsers(int page,int rows);
    public void deleteUsers(List<Integer> ids);
    public void delete(int userId);
    public User loadUserById(int userId);
    public void updateUser(User user);
    public List<User> fuzzyQuery(String sql);
    public int getMaxUserId();
    public int calcMaxPage(int rows);
    public int getUserId(String userName);
}
