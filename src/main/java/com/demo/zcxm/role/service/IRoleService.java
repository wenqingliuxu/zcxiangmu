package com.demo.zcxm.role.service;

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
}
