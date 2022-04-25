package com.controller.teacher;

import com.dao.IAccount;
import com.entity.Teachers;
import com.implement.TeacherAccImpIAcc;
import com.security.HashPassMD5;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("teacher_acc/sign-up")
public class SignUpTeacherController {
    @RequestMapping("")
    public String init_sign_up(){
        return "/WEB-INF/views/teacher/pages/authentication/checkPhone";
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public String checkPhone(@RequestParam("phoneNumber") String phoneFrForm, Model model){
        TeacherAccImpIAcc teacherAccImpIAcc = new TeacherAccImpIAcc();
        String url = "";
        Teachers teacherFound = teacherAccImpIAcc.findByPhone(phoneFrForm);
        if (teacherFound!=null){
            if (teacherFound.getUserName()!=null || teacherFound.getPassword() != null){
                model.addAttribute("notification","Số điện thoại này đã có tài khoản. Vui lòng chọn số khác!!");
                url = "/WEB-INF/views/teacher/pages/authentication/checkPhone";
            }else {
                model.addAttribute("teacherFound",teacherFound);
                url = "/WEB-INF/views/teacher/pages/authentication/sign-up";
            }
        }else {
            model.addAttribute("notification","Không thể tìm thấy tài khoản của bạn, vui lòng thử lại!!");
            model.addAttribute("oldPhone",phoneFrForm);
            url = "/WEB-INF/views/teacher/pages/authentication/checkPhone";
        }
        return url;
    }

    @RequestMapping(value = "/post",method = RequestMethod.POST)
    public String sign_up(HttpServletRequest request, RedirectAttributes redirectAttributes){
        TeacherAccImpIAcc teacherAccImpIAcc = new TeacherAccImpIAcc();
        int id = Integer.parseInt(request.getParameter("id"));
        String url = "";
        Teachers teacherFound = teacherAccImpIAcc.findById(id);
        if (teacherFound!=null){
            String newUserName = request.getParameter("newUserName");
            String newPass = request.getParameter("newPass");

            HashPassMD5 hashPassMD5 = new HashPassMD5();
            String hashedPass = hashPassMD5.toMD5(newPass);

            teacherFound.setUserName(newUserName);
            teacherFound.setPassword(hashedPass);

            boolean check_update = teacherAccImpIAcc.update(teacherFound);
            if (check_update == true){
                redirectAttributes.addAttribute("notification","Tạo tài khoản thành công!! Mời bạn đăng nhập lại...");
            }else {
                redirectAttributes.addFlashAttribute("notification","Không thể tạo tài khoản cho bạn vào lúc này. Vui lòng thử lại sau..");
            }
        }else {
            redirectAttributes.addAttribute("notification","Không thể tìm tài khoản của bạn, vui lòng thử lại!!");
        }
        url = "redirect:/teacher_acc/login";
        return url;
    }
}
