package com.demo.zcxm.role.dao;

import com.demo.zcxm.role.service.bo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: 刘旭
 * Date: 2019/10/6 14:10
 * @Version 1.0
 */
public interface IRoleDao {
//    根据用户Id查询角色id
    public List<Integer> selectRidByUid(int userId);
//    批量删除用户时，删除角色
    public void deleteRids(List<Integer> ids);
//    单个删除用户时，删除角色
    public void deleteRid(int userId);
//    查询用户已分配角色
    public List<Role> loadRoleByUserId(int userId);
//    查询用户未分配角色
    public List<Role> loadRoleByNoUserId(int userId);
//    给用户增加角色
    public void addRid(@Param("userId") int userId,@Param("rid") List<Integer> rid);
//    删除用户角色
    public void deleteRidByUserId(@Param("userId") int userId,@Param("rid") List<Integer> rid);
//    查询所有角色
    public List<Role> selectAllRole();
}
