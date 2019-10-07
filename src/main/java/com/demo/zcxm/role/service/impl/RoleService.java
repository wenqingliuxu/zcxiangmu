package com.demo.zcxm.role.service.impl;

import com.demo.zcxm.role.dao.IRoleDao;
import com.demo.zcxm.role.service.IRoleService;
import com.demo.zcxm.role.service.bo.Role;
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

    @Override
    public void deleteRids(List<Integer> ids) {
        roleDao.deleteRids(ids);
    }

    @Override
    public void deleteRid(int userId) {
        roleDao.deleteRid(userId);
    }

    @Override
    public List<Role> loadRoleByUserId(int userId) {
        return roleDao.loadRoleByUserId(userId);
    }

    @Override
    public List<Role> loadRoleByNoUserId(int userId) {
        return roleDao.loadRoleByNoUserId(userId);
    }

    @Override
    public void addRid(int userId,List<Integer> rid) {
        roleDao.addRid(userId, rid);
    }

    @Override
    public void deleteRidByUserId(int userId, List<Integer> rid) {
        roleDao.deleteRidByUserId(userId,rid);
    }
}
