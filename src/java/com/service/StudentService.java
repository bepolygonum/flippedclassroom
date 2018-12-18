package com.service;
import com.entity.Student;

import java.util.List;

public interface StudentService {
    Student  getStudentbyAccount(String account, String password);
    List<Student> getAllStudent();
    List<Student> getStudentbyInfo(String info);
    void deleteAstudent(String account);
    void deleteStudentByAccount(String[] obj);
    void resetStudent(String account);
    void modifyStudent(int uid,String user_account,String user_name,String user_email);
}
