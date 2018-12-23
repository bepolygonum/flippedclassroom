package com.service;
import com.dao.AdminDao;
import com.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author DELL
 */
@Service(value = "AdminService")
public class AdminServiceImpl{
    @Autowired
    AdminDao adminDao;

    public Admin getAdminByAccount(String account, String password) {
        return adminDao.getAdminByAccount(account,password);
    }
}
