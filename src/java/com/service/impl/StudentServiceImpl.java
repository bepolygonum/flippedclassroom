package com.service.impl;
import com.dao.StudentDao;
import com.entity.Student;
import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "StudentService")
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentDao studentDao;
    public Student getStudentbyAccount(String account, String password) {
        return studentDao.getStudentbyAccount(account,password);
    }

    public List<Student> getAllStudent(){
        return studentDao.getAllStudent();
    }

    @Override
    public List<Student> getStudentbyInfo(String info) {
        return studentDao.getStudentbyInfo(info);
    }

    @Override
    public void deleteAstudent(String account){ studentDao.deleteAstudent(account);}

    @Override
    public void deleteStudentByAccount(String[] obj){
        for(int i=0;i<obj.length;i++)
            studentDao.deleteAstudent(obj[i]);
    }
    @Override
    public void resetStudent(String account)
    { studentDao.resetStudent(account); }

    @Override
    public void modifyStudent(int uid,String user_account,String user_name,String user_email)
    { studentDao.modifyStudent(uid,user_account,user_name,user_email);}

}
