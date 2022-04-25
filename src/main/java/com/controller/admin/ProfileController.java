package com.controller.admin;

import com.entity.Admin;
import com.implement.AdminAccImpIAcc;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/admin/profile")
public class ProfileController {

    @RequestMapping(value = {"","/{usrName}"})
    public String profile(@PathVariable(name = "usrName", required = false) String usrName, Model model){
        AdminAccImpIAcc adminAccImpIAcc  = new AdminAccImpIAcc();
        Admin admin = adminAccImpIAcc.findByUsrName(usrName);
        model.addAttribute("admin_found",admin);
        return "/WEB-INF/views/admin/pages/user/user-profile";
    }

    @RequestMapping(value = "update-acc")
    public String update_acc(HttpServletRequest request, RedirectAttributes redirectAttributes){
        HttpSession session = request.getSession();
        AdminAccImpIAcc adminAccImpIAcc = new AdminAccImpIAcc();

        int id = Integer.parseInt(request.getParameter("id"));
        String usrName = (String) session.getAttribute("userName");
        String newName = request.getParameter("name");
        String newEmail = request.getParameter("email");
        String newPhone = request.getParameter("phone");
        String newAddress = request.getParameter("address");

        Admin oldAdm = adminAccImpIAcc.findByUsrName(usrName);
        boolean isUpdated = adminAccImpIAcc.update(new Admin(id, newName, usrName, oldAdm.getPassword(),newEmail, newPhone,newAddress, oldAdm.getRole(), oldAdm.getStatus()));
        if (isUpdated == true){
            session.removeAttribute("admName");
            session.setAttribute("admName", newName);
            redirectAttributes.addFlashAttribute("notification", "Cập nhật thành công");
        }else {
            redirectAttributes.addFlashAttribute("notification", "Cập nhật thất bại");
        }
        return "redirect:/admin/profile/" + usrName;
    }
}
