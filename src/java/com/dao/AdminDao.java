package com.dao;

import com.entity.Admin;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao {
    Admin getAdminByAccount(String account, String password);
}
