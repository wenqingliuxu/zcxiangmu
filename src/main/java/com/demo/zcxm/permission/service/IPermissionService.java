package com.demo.zcxm.permission.service;

import com.demo.zcxm.permission.service.bo.Permission;

import java.util.List;

/**
 * @Author: 刘旭
 * Date: 2019/10/8 8:56
 * @Version 1.0
 */
public interface IPermissionService {
    public List<Permission> loadAll();
    public List<Permission> loadPmsByRoleId(int roleId);
    public boolean deletePms(int roleId);
    public boolean addPms(int roleId,List<Integer> pid);
}
