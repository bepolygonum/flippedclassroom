package com.controller;

import com.entity.Admin;
import com.entity.Teacher;
import com.service.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author DELL
 */
@Controller
public class AdminTeacherController {

    @Autowired
    private TeacherServiceImpl teacherService;


    @RequestMapping(value = "/search-teacher", method = RequestMethod.GET)
    public String search(Model model, @RequestParam String info, String adminAccount) {
        List<Teacher> teacherList =teacherService.getTeacherByInfo(info);
        Admin admin=new Admin();
        admin.setAccount(adminAccount);
        model.addAttribute(admin);
        model.addAttribute(teacherList);
        return "admin-teacher";
    }

    @RequestMapping(value = "/admin-teacher")
    public String adminteacher(Model model, @RequestParam String adminAccount) {
        List<Teacher>  teacherList = teacherService.getAllTeacher();
        Admin admin=new Admin();
        admin.setAccount(adminAccount);
        model.addAttribute(admin);
        model.addAttribute(teacherList);
        return "admin-teacher";
    }

    @RequestMapping(value = "/create-teacher")
    public String createteacher(Model model, @RequestParam String adminAccount) {
        Admin admin=new Admin();
        admin.setAccount(adminAccount);
        model.addAttribute(admin);
        return "create-teacher";
    }

    @RequestMapping(value = "/create-a-teacher",method = RequestMethod.POST)
    public String createAteacher(Model model, @RequestParam String adminAccount,@RequestParam String userAccount,@RequestParam String userName,@RequestParam String userPassword,@RequestParam String userEmail) {
        Admin admin=new Admin();
        admin.setAccount(adminAccount);
        teacherService.createTeacher(userAccount,userName,userPassword,userEmail);
        List<Teacher>  teacherList = teacherService.getAllTeacher();
        model.addAttribute(admin);
        model.addAttribute(teacherList);
        return "admin-teacher";
    }

    @RequestMapping(value = "/delete-teacher")
    public String deleteteacher(Model model, @RequestParam String adminAccount,@RequestParam String delid) {
        Admin admin=new Admin();
        admin.setAccount(adminAccount);
        teacherService.deleteTeachersByAccount(delid);
        List<Teacher>  teacherList = teacherService.getAllTeacher();
        System.out.print(teacherList);
        model.addAttribute(admin);
        model.addAttribute(teacherList);
        return "admin-teacher";
    }


    @RequestMapping(value = "/delete-a-teacher")
    public String deleteAteacher(Model model, @RequestParam String adminAccount,@RequestParam String delid) {
        Admin admin=new Admin();
        admin.setAccount(adminAccount);
        teacherService.deleteTeacherByAccount(delid);
        List<Teacher>  teacherList = teacherService.getAllTeacher();
        model.addAttribute(admin);
        model.addAttribute(teacherList);
        return "admin-teacher";
    }

    @RequestMapping(value = "/modify-teacher")
    public String modifyTeacher(Model model, @RequestParam String adminAccount,@RequestParam String tid,@RequestParam String account,@RequestParam String name,@RequestParam String email) {
        Admin admin=new Admin();
        Teacher teacher=new Teacher();
        admin.setAccount(adminAccount);
        teacher.setAccount(account);
        teacher.setTeacherName(name);
        teacher.setEmail(email);
        model.addAttribute(admin);
        model.addAttribute("tid",tid);
        model.addAttribute(teacher);
        return "modify-teacher";
    }

    @RequestMapping(value = "/modify-a-teacher",method = RequestMethod.POST)
    public String modifyAteacher(Model model, @RequestParam String adminAccount,@RequestParam String tid,@RequestParam String userAccount,@RequestParam String userName,@RequestParam String userEmail) {
        Admin admin=new Admin();
        admin.setAccount(adminAccount);
        int uid=Integer.parseInt(tid);
        teacherService.modifyTeacher(uid,userAccount,userName,userEmail);
        List<Teacher>  teacherList = teacherService.getAllTeacher();
        model.addAttribute(admin);
        model.addAttribute(teacherList);
        return "admin-teacher";
    }

    @RequestMapping(value = "/reset-teacher")
    public String modifyAteacher(Model model, @RequestParam String adminAccount,@RequestParam String account) {
        Admin admin=new Admin();
        admin.setAccount(adminAccount);
        teacherService.resetTeacher(account);
        List<Teacher>  teacherList = teacherService.getAllTeacher();
        model.addAttribute(admin);
        model.addAttribute(teacherList);
        return "admin-teacher";
    }


}
