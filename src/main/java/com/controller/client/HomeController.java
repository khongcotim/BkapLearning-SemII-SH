package com.controller.client;

import com.entity.Category;
import com.entity.Course;
import com.implement.CategoryImp;
import com.implement.CourseImp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping(value = {"","/home","index"})
public class HomeController {
    @RequestMapping(value = "")
    public String home(Model model){
        CategoryImp categoryImp = new CategoryImp();
        CourseImp courseImp = new CourseImp();

        List<Category> categories = categoryImp.pagination(0,8);
        HashMap<Integer, List<Course>> cateCouseArr = new HashMap<>();
        categories.forEach(item->{
            cateCouseArr.put(item.getId(),courseImp.findByCate(item.getId()));
        });
        model.addAttribute("courseByCate", cateCouseArr);
        model.addAttribute("categories",categories);
        return "home";
    }
}
