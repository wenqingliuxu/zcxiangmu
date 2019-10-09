package com.demo.zcxm.renzheng.service.impl;

import com.demo.zcxm.renzheng.dao.IRenZhengDao;
import com.demo.zcxm.renzheng.service.IRenZhengService;
import com.demo.zcxm.renzheng.service.bo.RenZheng;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 刘旭
 * Date: 2019/10/9 23:30
 * @Version 1.0
 */
@Service
public class RenZhengService implements IRenZhengService {
    @Autowired
    private IRenZhengDao renZhengDao;

    @Override
    public void addRenZheng(RenZheng renZheng) {
        renZhengDao.addRenZheng(renZheng);
    }
}
