package com.service;
import com.entity.Teacher;

import java.util.List;

public interface TeacherService {
    Teacher getTeacherbyAccount(String account, String password);
    List<Teacher> getAllTeacher();
    List<Teacher> getTeacherbyInfo(String info);
    void createTeacher(String user_account,String user_name,String user_password,String user_email);
    void modifyTeacher(int uid,String user_account,String user_name,String user_email);
    void deleteAteacher(String account);
    void deleteTeacherByAccount(String[] obj);
    void resetTeacher(String account);

}
