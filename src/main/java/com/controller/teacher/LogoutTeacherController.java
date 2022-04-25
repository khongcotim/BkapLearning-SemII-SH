package com.controller.teacher;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("logout.htm")
public class LogoutTeacherController {
    @RequestMapping("")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        String teacherUsrN = (String) session.getAttribute("teacherUsrN");
        if (null != teacherUsrN){
            session.removeAttribute("teacherUsrN");
        }
        return "redirect:/teacher";
    }
}
