package com.controller.client;

import com.entity.Students;
import com.implement.CategoryImp;
import com.implement.StudentImp;
import com.security.HashPassMD5;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/sign-up")
public class SignUpController {

    @RequestMapping( value = "", method = RequestMethod.GET)
    public String init_signup(Model model){
        CategoryImp categoryImp = new CategoryImp();
        model.addAttribute("categories",categoryImp.pagination(0,8));
        return "WEB-INF/views/client/pages/signup";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String signup(HttpServletRequest request, RedirectAttributes redirectAttributes){
        HashPassMD5 hashPassMD5 = new HashPassMD5();
        StudentImp studentImp =  new StudentImp();

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String birthday = request.getParameter("birthday");
        String password = request.getParameter("password");

        String hashedPass = hashPassMD5.toMD5(password);

        Students newStudent = new Students();
        newStudent.setName(name);
        newStudent.setEmail(email);
        newStudent.setPhone(phone);
        newStudent.setBirthday(birthday);
        newStudent.setPassword(hashedPass);

        boolean checkInsert = studentImp.create(newStudent);
        if (checkInsert == true){
            redirectAttributes.addFlashAttribute("notification", "Đăng ký tài khoản thành công !!!");
            return "redirect:/login.html";
        }else {
            redirectAttributes.addFlashAttribute("notification", "Không thể tạo tài khoản lúc này!!!");
            return "redirect:/sign-up";
        }

    }
}
