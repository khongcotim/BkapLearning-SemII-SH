package com.controller.client;

import com.implement.CategoryImp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/contact.html")
public class ContactController {

    @RequestMapping("")
    public String contact(Model model){
        CategoryImp categoryImp = new CategoryImp();
        model.addAttribute("categories",categoryImp.pagination(0,8));
        return "WEB-INF/views/client/pages/contact";
    }
}
