package com.dao;

import com.entity.Admin;
import org.springframework.stereotype.Repository;

/**
 * @author DELL
 */
@Repository
public interface AdminDao {
    /**
     *getAdminByAccount
     *  @param account
     * @param password
     * @return
     */
    Admin getAdminByAccount(String account, String password);
}
