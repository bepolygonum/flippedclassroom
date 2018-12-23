package com.service;
import com.dao.StudentDao;
import com.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author DELL
 */
@Service(value = "StudentService")
public class StudentServiceImpl{
    @Autowired
    StudentDao studentDao;

    public List<Student> getAllStudent(){
        return studentDao.getAllStudent();
    }

    public List<Student> getStudentByInfo(String info) {
        return studentDao.getStudentByInfo(info);
    }

    public void deleteStudent(String account){ studentDao.deleteStudent(account);}

    public void deleteStudentByAccount(String[] obj){
        for(int i=0;i<obj.length;i++)
        {studentDao.deleteStudent(obj[i]);}
    }

    public void resetStudent(String account)
    { studentDao.resetStudent(account); }

    public void modifyStudent(int uid,String userAccount,String userName,String userEmail)
    { studentDao.modifyStudent(uid,userAccount,userName,userEmail);}

}
