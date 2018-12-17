package com.controller;

import com.entity.Student;
import com.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdminStudentController{
    @Autowired
    private StudentServiceImpl studentService;

    @RequestMapping(value = "/admin-student")
    public String adminstudent(Model model, @RequestParam String admin_name) {
        List<Student>  studentList = studentService.getAllStudent();
        model.addAttribute(admin_name);
        model.addAttribute(studentList);
        return "admin-student";
    }
}
