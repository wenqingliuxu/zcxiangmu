package com.demo.zcxm.user.service.impl;

import com.demo.zcxm.user.dao.IUserDao;
import com.demo.zcxm.user.service.IUserService;
import com.demo.zcxm.user.service.IUserService;
import com.demo.zcxm.user.service.bo.User;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        User user = userDao.getUserByUserName(userName);
        return user;
    }

    @Override
    public Integer getUserNameCount(String userName) {
        Integer userNameCount = userDao.getUserNameCount(userName);
        return userNameCount;
    }

    @Override
    public List<User> loadAllUsers(int page,int rows) {
        PageHelper.startPage(page,rows);
        List<User> userList = userDao.loadAllUsers(page, rows);
        return userList;
    }

    @Override
    public void deleteUsers(List<Integer> ids) {
        userDao.deleteUsers(ids);
    }

    @Override
    public void delete(int userId) {
        userDao.delete(userId);
    }

    @Override
    public User loadUserById(int userId) {
        User user = userDao.loadUserById(userId);
        return user;
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public List<User> fuzzyQuery(String sql) {
        List<User> users = userDao.fuzzyQuery(sql);
        return users;
    }

    @Override
    public int getMaxUserId() {
        int maxUserId = userDao.getMaxUserId();
        return maxUserId;
    }


    @Override
    public int calcMaxPage(int rows) {
        int totalCount = userDao.getTotalCount();
        return totalCount%rows==0?totalCount/rows:totalCount/rows+1;
    }


}
