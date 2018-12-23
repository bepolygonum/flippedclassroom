package com.controller;

import com.entity.Admin;
import com.entity.Student;
import com.service.StudentServiceImpl;
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
public class AdminStudentController{
    @Autowired
    private StudentServiceImpl studentService;

    @RequestMapping(value = "/admin-student",method = RequestMethod.GET)
    public String adminstudent(Model model, @RequestParam String adminAccount) {
        List<Student>  studentList = studentService.getAllStudent();
        Admin admin=new Admin();
        admin.setAccount(adminAccount);
        model.addAttribute(admin);
        model.addAttribute(studentList);
        return "admin-student";
    }

    @RequestMapping(value = "/search-student", method = RequestMethod.GET)
    public String search(Model model, @RequestParam String info, String adminAccount) {
        List<Student> studentList =studentService.getStudentByInfo(info);
        Admin admin=new Admin();
        admin.setAccount(adminAccount);
        model.addAttribute(admin);
        model.addAttribute(studentList);
        return "admin-student";
    }

    @RequestMapping(value = "/delete-student")
    public String deleteteacher(Model model, @RequestParam String adminAccount,String delid) {
        Admin admin=new Admin();
        admin.setAccount(adminAccount);
        String number="";
        if(delid!=null)
        {number=delid.substring(0,delid.length()-1);}
        String[] obj = number.split(",");
        studentService.deleteStudentByAccount(obj);
        List<Student>  studentList = studentService.getAllStudent();
        System.out.print(studentList);
        model.addAttribute(admin);
        model.addAttribute(studentList);
        return "admin-student";
    }

    @RequestMapping(value = "/delete-a-student")
    public String deleteAteacher(Model model, @RequestParam String adminAccount,String delid) {
        Admin admin=new Admin();
        admin.setAccount(adminAccount);
        studentService.deleteStudent(delid);
        List<Student>  studentList = studentService.getAllStudent();
        model.addAttribute(admin);
        model.addAttribute(studentList);
        return "admin-student";
    }

    @RequestMapping(value = "/modify-student")
    public String modifyTeacher(Model model, @RequestParam String adminAccount,@RequestParam String tid,@RequestParam String account,@RequestParam String name,@RequestParam String email) {
        Admin admin=new Admin();
        Student student=new Student();
        admin.setAccount(adminAccount);
        student.setAccount(account);
        student.setStudentName(name);
        student.setEmail(email);
        model.addAttribute(admin);
        model.addAttribute("tid",tid);
        model.addAttribute(student);
        return "modify-student";
    }

    @RequestMapping(value = "/modify-a-student",method = RequestMethod.POST)
    public String modifyAteacher(Model model, @RequestParam String adminAccount,@RequestParam String tid,@RequestParam String userAccount,@RequestParam String userName,@RequestParam String userEmail) {
        Admin admin=new Admin();
        admin.setAccount(adminAccount);
        int uid=Integer.parseInt(tid);
        studentService.modifyStudent(uid,userAccount,userName,userEmail);
        List<Student>  studentList = studentService.getAllStudent();
        model.addAttribute(admin);
        model.addAttribute(studentList);
        return "admin-student";
    }

    @RequestMapping(value = "/reset-student")
    public String modifyAteacher(Model model, @RequestParam String adminAccount,@RequestParam String account) {
        Admin admin=new Admin();
        admin.setAccount(adminAccount);
        studentService.resetStudent(account);
        List<Student>  studentList = studentService.getAllStudent();
        model.addAttribute(admin);
        model.addAttribute(studentList);
        return "admin-student";
    }
}
