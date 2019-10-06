package com.demo.zcxm.role.service.impl;

import com.demo.zcxm.role.dao.IRoleDao;
import com.demo.zcxm.role.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 刘旭
 * Date: 2019/10/6 14:25
 * @Version 1.0
 */
@Service
public class RoleService implements IRoleService {
    @Autowired
    private IRoleDao roleDao;
    @Override
    public List<Integer> selectRidByUid(int userId) {
        return roleDao.selectRidByUid(userId);
    }
}
