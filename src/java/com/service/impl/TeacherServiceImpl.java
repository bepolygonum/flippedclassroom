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

    @Override
    public List<Teacher> getAllTeacher(){
        return teacherDao.getAllTeacher();
    }

    @Override
    public List<Teacher> getTeacherByInfo(String info) {
        return teacherDao.getTeacherByInfo(info);
    }

    @Override
    public void createTeacher(String user_account,String user_name,String user_password,String user_email)
    { teacherDao.createTeacher(user_account,user_name,user_password,user_email);}

    @Override
    public void modifyTeacher(int uid,String user_account,String user_name,String user_email)
    { teacherDao.modifyTeacher(uid,user_account,user_name,user_email);}

    @Override
    public void deleteTeacherByAccount(String account){ teacherDao.deleteTeacherByAccount(account);}

    @Override
    public void deleteTeachersByAccount(String ids){
        String number="";
        if(ids!=null)
            number=ids.substring(0,ids.length()-1);
        String[] obj = number.split(",");
        for(int i=0;i<obj.length;i++)
            teacherDao.deleteTeacherByAccount(obj[i]);
    }

    @Override
    public void resetTeacher(String account)
    { teacherDao.resetTeacher(account); }


}
