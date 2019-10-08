package com.demo.zcxm.permission.dao;

import com.demo.zcxm.permission.service.bo.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: 刘旭
 * Date: 2019/10/8 8:56
 * @Version 1.0
 */
public interface IPermissionDao {
//    查询所有权限信息
public List<Permission> loadAll();
    public List<Permission> loadPmsByRoleId(@Param("roleId") int roleId);
    public int deletePms(int roleId);
    public int addPms(@Param("roleId") int roleId,@Param("pid") List<Integer> pid);
}
