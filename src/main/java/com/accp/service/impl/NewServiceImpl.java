package com.accp.service.impl;

import com.accp.dao.NewDao;
import com.accp.dao.impl.NewDaoImpl;
import com.accp.entity.New;
import com.accp.service.NewService;

import java.util.List;

/**
 * Created by Sall on 2019-2-18.
 */
public class NewServiceImpl implements NewService {
    NewDao newdao=new NewDaoImpl();
    public List<New> selectAll() {
        return newdao.selectAll();
    }
}
