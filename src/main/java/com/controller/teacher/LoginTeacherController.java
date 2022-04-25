package com.controller.teacher;

import com.entity.Teachers;
import com.implement.TeacherAccImpIAcc;
import com.security.HashPassMD5;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("teacher_acc/login")
public class LoginTeacherController {

    @RequestMapping("")
    public String init_login(Model model){
        model.addAttribute("teacherAcc",new Teachers());
        return "WEB-INF/views/teacher/pages/authentication/login";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String login(@ModelAttribute("teacherAcc") Teachers teacherAccount, RedirectAttributes redirectAttributes,HttpServletRequest request){
        String url = "";
        String referer = request.getHeader("Referer");
        TeacherAccImpIAcc teacherAccImpIAcc = new TeacherAccImpIAcc();
        Teachers accountFound = teacherAccImpIAcc.findByEmail(teacherAccount.getEmail());
        if (null != accountFound){
            HashPassMD5 hashPassMD5 = new HashPassMD5();
            if (accountFound.getPassword()==null){
                redirectAttributes.addFlashAttribute("notification","Tài khoản không có mật khẩu!!!");
                url = referer;
            }else if (hashPassMD5.verifyMD5(accountFound.getPassword(), teacherAccount.getPassword()) == true){
                HttpSession session = request.getSession();
                session.setAttribute("teacherUsrN",accountFound.getUserName());
                session.setAttribute("teacherAvt",accountFound.getAvatar());
                session.setAttribute("teacherName",accountFound.getName());
                session.setAttribute("teacherId",accountFound.getId());
                url = "/teacher";
            }else {
                redirectAttributes.addFlashAttribute("notification","Sai tài khoản và mật khẩu!!");
                redirectAttributes.addFlashAttribute("teacherAcc",teacherAccount);
                // Return redirect back to login page;
                url = referer;
            }
        }else {
            redirectAttributes.addFlashAttribute("notification","Tài khoản không tồn tại!!");
            redirectAttributes.addFlashAttribute("teacherAcc",teacherAccount);
            // Return redirect back to login page;
            url = referer;
        }
        return "redirect:" + url;
    }
}
