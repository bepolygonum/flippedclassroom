package com.service;
import com.dao.TeacherDao;
import com.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author DELL
 */
@Service(value = "TeacherService")
public class TeacherServiceImpl {
    @Autowired
    TeacherDao teacherDao;

    public List<Teacher> getAllTeacher(){
        return teacherDao.getAllTeacher();
    }

    public List<Teacher> getTeacherByInfo(String info) {
        return teacherDao.getTeacherByInfo(info);
    }

    public void createTeacher(String userAccount,String userName,String userPassword,String userEmail)
    { teacherDao.createTeacher(userAccount,userName,userPassword,userEmail);}

    public void modifyTeacher(int uid,String userAccount,String userName,String userEmail)
    { teacherDao.modifyTeacher(uid,userAccount,userName,userEmail);}

    public void deleteTeacherByAccount(String account){ teacherDao.deleteTeacherByAccount(account);}

    public void deleteTeachersByAccount(String ids){
        String number="";
        if(ids!=null)
        {number=ids.substring(0,ids.length()-1);}
        String[] obj = number.split(",");
        for(int i=0;i<obj.length;i++)
        {teacherDao.deleteTeacherByAccount(obj[i]);}
    }

    public void resetTeacher(String account)
    { teacherDao.resetTeacher(account); }


}
