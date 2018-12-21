package com.dao;

import com.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao {
    List<Student> getAllStudent();
    List<Student> getStudentByInfo(String info);
    void deleteStudent(String account);
    void resetStudent(String account);
    void modifyStudent(int uid,String user_account,String user_name,String user_email);
}
