package com.service.impl;
import com.dao.AdminDao;
import com.entity.Admin;
import com.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "AdminService")
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminDao adminDao;
    public Admin getAdminbyAccount(int account, String password) {
        return adminDao.getAdminbyAccount(account,password);
    }
}
