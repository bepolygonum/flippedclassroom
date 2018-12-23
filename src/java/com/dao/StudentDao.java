package com.dao;

import com.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author DELL
 */
@Repository
public interface StudentDao {
    /**
     * getAllStudent
     * @return
     */
    List<Student> getAllStudent();

    /**
     * getStudentByInfo
     * @param info
     * @return
     */
    List<Student> getStudentByInfo(String info);

    /**
     * deleteStudent
     * @param account
     */
    void deleteStudent(String account);

    /**
     * resetStudent
     * @param account
     */
    void resetStudent(String account);

    /**
     * modifyStudent
     * @param uid
     * @param userAccount
     * @param userName
     * @param userEmail
     */
    void modifyStudent(int uid,String userAccount,String userName,String userEmail);
}
