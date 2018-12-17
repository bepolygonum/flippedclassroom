package com.service;
import com.entity.Admin;
public interface AdminService {
    Admin getAdminbyAccount(int account, String password);
}
