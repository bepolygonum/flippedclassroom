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

    @Override
    public List<Student> getAllStudent(){
        return studentDao.getAllStudent();
    }

    @Override
    public List<Student> getStudentByInfo(String info) {
        return studentDao.getStudentByInfo(info);
    }

    @Override
    public void deleteStudent(String account){ studentDao.deleteStudent(account);}

    @Override
    public void deleteStudentByAccount(String[] obj){
        for(int i=0;i<obj.length;i++)
            studentDao.deleteStudent(obj[i]);
    }
    @Override
    public void resetStudent(String account)
    { studentDao.resetStudent(account); }

    @Override
    public void modifyStudent(int uid,String user_account,String user_name,String user_email)
    { studentDao.modifyStudent(uid,user_account,user_name,user_email);}

}
