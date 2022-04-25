package com.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("logout.html")
public class LogoutController {
    @RequestMapping("")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("studentName");
        return "redirect:/";
    }
}
