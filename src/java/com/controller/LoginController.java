package com.controller;

import com.entity.Admin;
import com.entity.Teacher;
import com.service.AdminServiceImpl;
import com.service.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author DELL
 */
@Controller
public class LoginController {
    @Autowired
    private AdminServiceImpl adminService;
    @Autowired
    private TeacherServiceImpl teacherService;

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String login(Model model, @RequestParam String userAccount, @RequestParam String password, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=gb2312");
        PrintWriter out = response.getWriter();
        Admin admin = adminService.getAdminByAccount(userAccount,password);
        List<Teacher> teacherList =teacherService.getAllTeacher();
        if (admin!=null) {
            //跳转至管理员管理教师信息的界面
            model.addAttribute(admin);
            model.addAttribute(teacherList);
            return "admin-teacher";
        }
        else {
            out.print("<script>alert('用户名或密码错误');history.go(-1);</script>");
        }
        return "";
    }
}
