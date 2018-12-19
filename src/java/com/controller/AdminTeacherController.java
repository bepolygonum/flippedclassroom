package com.controller;

import com.entity.Admin;
import com.entity.Teacher;
import com.service.impl.AdminServiceImpl;
import com.service.impl.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdminTeacherController {

    @Autowired
    private TeacherServiceImpl teacherService;


    @RequestMapping(value = "/search-teacher", method = RequestMethod.GET)
    public String search(Model model, @RequestParam String info, String admin_account) {
        List<Teacher> teacherList =teacherService.getTeacherbyInfo(info);
        Admin admin=new Admin();
        admin.setAccount(admin_account);
        model.addAttribute(admin);
        model.addAttribute(teacherList);
        return "admin-teacher";
    }

    @RequestMapping(value = "/admin-teacher")
    public String adminteacher(Model model, @RequestParam String admin_account) {
        List<Teacher>  teacherList = teacherService.getAllTeacher();
        Admin admin=new Admin();
        admin.setAccount(admin_account);
        model.addAttribute(admin);
        model.addAttribute(teacherList);
        return "admin-teacher";
    }

    @RequestMapping(value = "/create-teacher")
    public String createteacher(Model model, @RequestParam String admin_account) {
        Admin admin=new Admin();
        admin.setAccount(admin_account);
        model.addAttribute(admin);
        return "create-teacher";
    }

    @RequestMapping(value = "/create-a-teacher",method = RequestMethod.POST)
    public String createAteacher(Model model, @RequestParam String admin_account,@RequestParam String user_account,@RequestParam String user_name,@RequestParam String user_password,@RequestParam String user_email) {
        Admin admin=new Admin();
        admin.setAccount(admin_account);
        teacherService.createTeacher(user_account,user_name,user_password,user_email);
        List<Teacher>  teacherList = teacherService.getAllTeacher();
        model.addAttribute(admin);
        model.addAttribute(teacherList);
        return "admin-teacher";
    }

    @RequestMapping(value = "/delete-teacher")
    public String deleteteacher(Model model, @RequestParam String admin_account,@RequestParam String delid) {
        Admin admin=new Admin();
        admin.setAccount(admin_account);
        String number="";
        if(delid!=null)
            number=delid.substring(0,delid.length()-1);
        String[] obj = number.split(",");
        teacherService.deleteTeacherByAccount(obj);
        List<Teacher>  teacherList = teacherService.getAllTeacher();
        System.out.print(teacherList);
        model.addAttribute(admin);
        model.addAttribute(teacherList);
        return "admin-teacher";
    }


    @RequestMapping(value = "/delete-a-teacher")
    public String deleteAteacher(Model model, @RequestParam String admin_account,@RequestParam String delid) {
        Admin admin=new Admin();
        admin.setAccount(admin_account);
        teacherService.deleteAteacher(delid);
        List<Teacher>  teacherList = teacherService.getAllTeacher();
        model.addAttribute(admin);
        model.addAttribute(teacherList);
        return "admin-teacher";
    }

    @RequestMapping(value = "/modify-teacher")
    public String modifyTeacher(Model model, @RequestParam String admin_account,@RequestParam String tid,@RequestParam String account,@RequestParam String name,@RequestParam String email) {
        Admin admin=new Admin();
        Teacher teacher=new Teacher();
        admin.setAccount(admin_account);
        teacher.setAccount(account);
        teacher.setTeacher_name(name);
        teacher.setEmail(email);
        model.addAttribute(admin);
        model.addAttribute("tid",tid);
        model.addAttribute(teacher);
        return "ModifyTeacher";
    }

    @RequestMapping(value = "/modify-a-teacher",method = RequestMethod.POST)
    public String modifyAteacher(Model model, @RequestParam String admin_account,@RequestParam String tid,@RequestParam String user_account,@RequestParam String user_name,@RequestParam String user_email) {
        Admin admin=new Admin();
        admin.setAccount(admin_account);
        int uid=Integer.parseInt(tid);
        teacherService.modifyTeacher(uid,user_account,user_name,user_email);
        List<Teacher>  teacherList = teacherService.getAllTeacher();
        model.addAttribute(admin);
        model.addAttribute(teacherList);
        return "admin-teacher";
    }

    @RequestMapping(value = "/reset-teacher")
    public String modifyAteacher(Model model, @RequestParam String admin_account,@RequestParam String account) {
        Admin admin=new Admin();
        admin.setAccount(admin_account);
        teacherService.resetTeacher(account);
        List<Teacher>  teacherList = teacherService.getAllTeacher();
        model.addAttribute(admin);
        model.addAttribute(teacherList);
        return "admin-teacher";
    }


}
