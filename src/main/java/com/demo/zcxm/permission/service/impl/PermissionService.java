package com.demo.zcxm.permission.service.impl;

import com.demo.zcxm.permission.dao.IPermissionDao;
import com.demo.zcxm.permission.service.IPermissionService;
import com.demo.zcxm.permission.service.bo.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 刘旭
 * Date: 2019/10/8 8:56
 * @Version 1.0
 */
@Service
public class PermissionService implements IPermissionService {
    @Autowired
    private IPermissionDao permissionDao;

    @Override
    public List<Permission> loadAll(){
        return permissionDao.loadAll();
    }
    @Override
    public List<Permission> loadPmsByRoleId(int roleId){
        return permissionDao.loadPmsByRoleId(roleId);
    }

    @Override
    public boolean deletePms(int roleId) {
        int count=0;
        count=permissionDao.deletePms(roleId);
        return count>0?true:false;
    }

    @Override
    public boolean addPms(int roleId,List<Integer> pid) {
        int count=0;
        count=permissionDao.addPms(roleId,pid);
        return count>0?true:false;
    }
}
