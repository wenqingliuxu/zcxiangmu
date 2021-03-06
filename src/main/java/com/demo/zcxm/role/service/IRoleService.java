package com.demo.zcxm.role.service;

import com.demo.zcxm.role.service.bo.Role;

import java.util.List;

/**
 * @Author: 刘旭
 * Date: 2019/10/6 14:13
 * @Version 1.0
 */
public interface IRoleService {
    public List<Integer> selectRidByUid(int userId);
    public void deleteRids(List<Integer> ids);
    public void deleteRid(int userId);
    public List<Role> loadRoleByUserId(int userId);
    public List<Role> loadRoleByNoUserId(int userId);
    public void addRid(int userId,List<Integer> rid);
    public void deleteRidByUserId(int userId,List<Integer> rid);
    public List<Role> selectAllRole();

}
