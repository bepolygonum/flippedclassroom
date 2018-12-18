package com.dao;

import com.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao {
    Student getStudentbyAccount(String account, String password);
    List<Student> getAllStudent();
    List<Student> getStudentbyInfo(String info);
    void deleteAstudent(String account);
    void resetStudent(String account);
    void modifyStudent(int uid,String user_account,String user_name,String user_email);
}
