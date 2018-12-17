package com.dao;

import com.entity.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherDao {
    Teacher getTeacherbyAccount(String account, String password);
    List<Teacher> getAllTeacher();
    List<Teacher> getTeacherbyInfo(String info);
    void createTeacher(String user_account,String user_name,String user_password,String user_email);
    void deleteAteacher(String account);

}
