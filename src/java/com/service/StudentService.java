package com.service;
import com.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudent();
    List<Student> getStudentByInfo(String info);
    void deleteStudent(String account);
    void deleteStudentByAccount(String[] obj);
    void resetStudent(String account);
    void modifyStudent(int uid,String user_account,String user_name,String user_email);
}
