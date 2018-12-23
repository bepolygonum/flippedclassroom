package com.dao;

import com.entity.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author DELL
 */
@Repository
public interface TeacherDao {
    /**
     * getAllTeacher
     * @return
     */
    List<Teacher> getAllTeacher();

    /**
     * getTeacherByInfo
     * @param info
     * @return
     */
    List<Teacher> getTeacherByInfo(String info);

    /**
     * createTeacher
     * @param userAccount
     * @param userName
     * @param userPassword
     * @param userEmail
     */
    void createTeacher(String userAccount,String userName,String userPassword,String userEmail);

    /**
     * modifyTeacher
     * @param uid
     * @param userAccount
     * @param userName
     * @param userEmail
     */
    void modifyTeacher(int uid,String userAccount,String userName,String userEmail);

    /**
     * deleteTeacherByAccount
     * @param account
     */
    void deleteTeacherByAccount(String account);

    /**
     * resetTeacher
     * @param account
     */
    void resetTeacher(String account);
}
