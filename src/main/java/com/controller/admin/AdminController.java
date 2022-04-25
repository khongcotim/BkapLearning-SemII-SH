package com.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("admin")
public class AdminController {
    @RequestMapping("")
    public String dashboard(){
        return "WEB-INF/views/admin/index";
    }

    @RequestMapping("logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        String usrName = (String) session.getAttribute("userName");
        if (null != usrName){
            session.removeAttribute("userName");
        }
        return "redirect:/admin";
    }
}