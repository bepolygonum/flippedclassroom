package com.dao;

import com.entity.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherDao {
    List<Teacher> getAllTeacher();
    List<Teacher> getTeacherByInfo(String info);
    void createTeacher(String user_account,String user_name,String user_password,String user_email);
    void modifyTeacher(int uid,String user_account,String user_name,String user_email);
    void deleteTeacherByAccount(String account);
    void resetTeacher(String account);
}
