package com.service.impl;
import com.dao.TeacherDao;
import com.entity.Teacher;
import com.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "TeacherService")
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherDao teacherDao;
    public Teacher getTeacherbyAccount(String account, String password) {
        return teacherDao.getTeacherbyAccount(account,password);
    }
    @Override
    public List<Teacher> getAllTeacher(){
        return teacherDao.getAllTeacher();
    }

    @Override
    public List<Teacher> getTeacherbyInfo(String info) {
        return teacherDao.getTeacherbyInfo(info);
    }

    @Override
    public void createTeacher(String user_account,String user_name,String user_password,String user_email)
    { teacherDao.createTeacher(user_account,user_name,user_password,user_email);}

    @Override
    public void deleteAteacher(String account){ teacherDao.deleteAteacher(account);}

    @Override
    public void deleteTeacherByAccount(String[] obj){
        for(int i=0;i<obj.length;i++)
            teacherDao.deleteAteacher(obj[i]);}
}
