package com.dao;

import com.entity.Admin;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao {
    Admin getAdminbyAccount(String account, String password);
}
