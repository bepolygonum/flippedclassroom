package com.controller;

import com.entity.Admin;
import com.entity.Student;
import com.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdminStudentController{
    @Autowired
    private StudentServiceImpl studentService;

    @RequestMapping(value = "/admin-student",method = RequestMethod.GET)
    public String adminstudent(Model model, @RequestParam String admin_account) {
        List<Student>  studentList = studentService.getAllStudent();
        Admin admin=new Admin();
        admin.setAccount(admin_account);
        model.addAttribute(admin);
        model.addAttribute(studentList);
        return "admin-student";
    }

    @RequestMapping(value = "/search-student", method = RequestMethod.GET)
    public String search(Model model, @RequestParam String info, String admin_account) {
        List<Student> studentList =studentService.getStudentbyInfo(info);
        Admin admin=new Admin();
        admin.setAccount(admin_account);
        model.addAttribute(admin);
        model.addAttribute(studentList);
        return "admin-student";
    }

    @RequestMapping(value = "/delete-student")
    public String deleteteacher(Model model, @RequestParam String admin_account,String delid) {
        Admin admin=new Admin();
        admin.setAccount(admin_account);
        String number="";
        if(delid!=null)
            number=delid.substring(0,delid.length()-1);
        String[] obj = number.split(",");
        studentService.deleteStudentByAccount(obj);
        List<Student>  studentList = studentService.getAllStudent();
        System.out.print(studentList);
        model.addAttribute(admin);
        model.addAttribute(studentList);
        return "admin-student";
    }

    @RequestMapping(value = "/delete-a-student")
    public String deleteAteacher(Model model, @RequestParam String admin_account,String delid) {
        Admin admin=new Admin();
        admin.setAccount(admin_account);
        studentService.deleteAstudent(delid);
        List<Student>  studentList = studentService.getAllStudent();
        model.addAttribute(admin);
        model.addAttribute(studentList);
        return "admin-student";
    }
}
