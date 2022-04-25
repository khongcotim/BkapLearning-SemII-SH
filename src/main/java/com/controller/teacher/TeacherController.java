package com.controller.teacher;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("teacher")
public class TeacherController {
    @RequestMapping("")
    public String teacher(){
        return "/WEB-INF/views/teacher/pages/index";
    }
}
