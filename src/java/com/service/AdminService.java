package com.service;
import com.entity.Admin;
public interface AdminService {
    Admin getAdminByAccount(String account, String password);
}
