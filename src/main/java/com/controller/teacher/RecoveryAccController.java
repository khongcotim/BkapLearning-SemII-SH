package com.controller.teacher;

import com.entity.Teachers;
import com.implement.TeacherAccImpIAcc;
import com.security.HashPassMD5;
import com.sun.xml.internal.ws.resources.SenderMessages;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Random;

@Controller
@RequestMapping("teacher_acc/forgot-pass")
public class RecoveryAccController {
    @RequestMapping("")
    public String recovery(){
        return "/WEB-INF/views/teacher/pages/authentication/recovery";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String checkExistAccount(@RequestParam("email") String email, RedirectAttributes redirectAttributes,HttpServletRequest request){
        String url = "";
        String backUrl = request.getHeader("Referer");
        TeacherAccImpIAcc teacherAccImpIAcc = new TeacherAccImpIAcc();
        Teachers accountFound = teacherAccImpIAcc.findByEmail(email);

        if (accountFound != null){
            String mailFrAcc = accountFound.getEmail();
            JavaMailSender javaMailSender = new JavaMailSenderImpl();
            SimpleMailMessage mail = new SimpleMailMessage();
            Random random = new Random();
            String recoveryCode = String.valueOf(random.nextInt(6));
            HttpSession session = request.getSession();
            session.setAttribute("recovery_code",recoveryCode);
            session.setMaxInactiveInterval(400);
            session.setAttribute("teacher_email_recovery",accountFound.getEmail());
            mail.setTo(mailFrAcc);
            mail.setSubject("Recovery code from Elearning System!!!");
            mail.setText("Hello!! Here is your code to recovery account. Don't share it to anyone!!!\n" +
                    "Your code is: " + recoveryCode + "\n" +
                    "Your code have effective for 5 minutes");
            javaMailSender.send(mail);
            redirectAttributes.addFlashAttribute("notification","Sent code to your mail. Please check it to recovery your account!!!");
            url = "redirect:/teacher_acc/forgot-pass/verify-code";
        }else {
            redirectAttributes.addFlashAttribute("notification","Can not find your account!! Please try again latter.");
            url = "redirect:" + backUrl;
        }
        return url;
    }

    @RequestMapping("verify-code")
    public String init_verify_code(){
        return "/WEB-INF/views/teacher/pages/authentication/verify-code";
    }

    @RequestMapping(value = "verify-code",method = RequestMethod.POST)
    public String verify_code(HttpServletRequest request, RedirectAttributes redirectAttributes){
        String backUrl = request.getHeader("Referer");
        String url = "";
        HttpSession session = request.getSession();
        String code = request.getParameter("code");
        String code_fr_session = (String) session.getAttribute("recovery_code");
        if (code_fr_session.equals(code)){
            url = "redirect:/set-up";
        }else {
            redirectAttributes.addFlashAttribute("notification","Mã xác nhận không chính xác!!");
            url = "redirect:" + backUrl;
        }
        return url;
    }

    @RequestMapping("set-up")
    public String init_set_up(){
        return "/WEB-INF/views/teacher/pages/authentication/update-pass";
    }

    @RequestMapping(value = "set-up", method = RequestMethod.POST)
    public String updatePassword(HttpServletRequest request, RedirectAttributes redirectAttributes){
        String backUrl = request.getHeader("Referer");
        String newPass = request.getParameter("newPass");
        HttpSession session = request.getSession();
        String url = "";

        String mail = (String) session.getAttribute("teacher_email_recovery");
        TeacherAccImpIAcc teacherAccImpIAcc = new TeacherAccImpIAcc();
        Teachers teacherFound = teacherAccImpIAcc.findByEmail(mail);
        HashPassMD5 hashPassMD5 = new HashPassMD5();
        teacherFound.setPassword(hashPassMD5.toMD5(newPass));

        boolean updateAcc = teacherAccImpIAcc.update(teacherFound);
        if (updateAcc == true){
            redirectAttributes.addFlashAttribute("notification","Cập nhật mật khẩu thành công! Vui lòng đăng nhập lại");
            url = "redirect:/teacher_acc/login";
        }else {
            redirectAttributes.addFlashAttribute("notification","Cập nhật mật khẩu thất bại! Vui lòng thử lại sau..");
            url = "redirect:" + backUrl;
        }
        return "/WEB-INF/views/teacher/pages/authentication/update-pass";
    }

}
