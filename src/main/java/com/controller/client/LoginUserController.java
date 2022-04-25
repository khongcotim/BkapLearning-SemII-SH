package com.controller.client;

import com.entity.Students;
import com.implement.CategoryImp;
import com.implement.StudentImp;
import com.security.HashPassMD5;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/login.html")
public class LoginUserController {
    @RequestMapping(value = {"", "{course_id}/{id_less}"}, method = RequestMethod.GET)
    public String login(@PathVariable(name = "course_id", required = false) Integer courseId, @PathVariable(name = "id_less", required = false) Integer lessonId,Model model){
        CategoryImp categoryImp = new CategoryImp();
        model.addAttribute("categories",categoryImp.pagination(0,8));
        return "WEB-INF/views/client/pages/login";
    }

    @RequestMapping(value = {"", "{course_id}/{id_less}"}, method = RequestMethod.POST)
    public String postLogin(@PathVariable(name = "course_id", required = false) Integer courseId, @PathVariable(name = "id_less", required = false) Integer lessonId,
                            HttpServletRequest request, RedirectAttributes redirectAttributes){

        System.out.println(courseId);
        System.out.println(lessonId);
        CategoryImp categoryImp = new CategoryImp();
        redirectAttributes.addFlashAttribute("categories",categoryImp.pagination(0,8));
        StudentImp studentImp = new StudentImp();
        Students studentFound = studentImp.findByEmail(request.getParameter("email"));

        if (studentFound!=null){
            HashPassMD5 hashPassMD5 = new HashPassMD5();
            if (hashPassMD5.verifyMD5(studentFound.getPassword(),request.getParameter("password")) == true){
                HttpSession session = request.getSession();
                session.setAttribute("studentName", studentFound.getName());
                if (lessonId!=null || courseId != null){
                    return "redirect:/course.html/videos?cour_id=" + courseId + "&id_less=" + lessonId;
                }else {
                    return "redirect:/";
                }
            }
            redirectAttributes.addFlashAttribute("notification", "Sai tài khoản hoặc mật khẩu !!");
            return "redirect:/login.html";
        }
        return "redirect:/";
    }
}
