package com.controller.admin;

import com.entity.Admin;
import com.implement.AdminAccImpIAcc;
import com.security.HashPassMD5;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("login.php")
public class LoginAdmController {
    @RequestMapping("")
    public String init_login(Model model, HttpServletRequest request){
        model.addAttribute("admins", new Admin());
            return "/WEB-INF/views/admin/pages/authentication/login";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String login(@ModelAttribute("admins") Admin admin, Model model, HttpServletRequest request, RedirectAttributes redirectAttributes){
        HashPassMD5 hashPassMD5 = new HashPassMD5();
        AdminAccImpIAcc adminAccImpIAcc = new AdminAccImpIAcc();
        Admin adminFound = adminAccImpIAcc.findByEmail(admin.getEmail());
        String url = null;
        String referer = request.getHeader("Referer");
        if (null != adminFound){
            if (adminFound.getPassword() == null){
                redirectAttributes.addFlashAttribute("notification","Mật khẩu không tồn tại !!!");
                url = referer;
            }else if (hashPassMD5.verifyMD5(adminFound.getPassword(),admin.getPassword())){
                HttpSession session = request.getSession();
                session.setAttribute("userName",adminFound.getUsrName());
                session.setAttribute("admName",adminFound.getName());
                url = "/admin";
            }else{
                redirectAttributes.addFlashAttribute("notification","Sai tài khoản hoặc mật khẩu!!");
                url = referer;
            }

        }else {
            //sai tk và mật khẩu
            redirectAttributes.addFlashAttribute("notification","Sai tài khoản và mật khẩu. Vui lòng thử lại !!");
            // Return redirect back to login page;
            url = referer;
        }
        return "redirect:" + url;
    }
}
