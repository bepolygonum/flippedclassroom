package com.service;
import com.entity.Admin;
public interface AdminService {
    Admin getAdminbyAccount(String account, String password);
}
