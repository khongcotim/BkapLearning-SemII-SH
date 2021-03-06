package com.controller.admin;

import com.dao.IDao;
import com.entity.Course;
import com.entity.Lesson;
import com.implement.CategoryImp;
import com.implement.CourseImp;
import com.implement.LessonImp;
import com.implement.TeacherImp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;

@Controller
@RequestMapping("admin/lesson")
public class LessonAdminController {

    @RequestMapping(value = {"", "/page/{page}"})
    public String lesson(@RequestParam(name = "page", required = false) Integer page, Model model){
        LessonImp lessonImp = new LessonImp();
        int itemOnPage = 8;
        int totalLesson = lessonImp.selectCount();
        int pages = (int) Math.ceil((double) totalLesson / itemOnPage);
        model.addAttribute("pages", pages);
        if (page == null) {
            page = 0;
        }
        List<Lesson> lessonList = lessonImp.pagination(page-1,itemOnPage);
        model.addAttribute("lesson",lessonList);
        return "/WEB-INF/views/admin/pages/lesson/list_all";
    }

    @RequestMapping("init-insert")
    public String init_insert(Model model){
        CourseImp courseImp = new CourseImp();
        List<Course> courseList = courseImp.getAll();
        model.addAttribute("courses",courseList);
        model.addAttribute("newLesson",new Lesson());
        return "/WEB-INF/views/admin/pages/lesson/create_new";
    }

    @RequestMapping("insert")
    public String insert(@Valid @ModelAttribute("newLesson") Lesson newLesson, BindingResult result, Model model){
        String notification;
        LessonImp lessonImp = new LessonImp();
        CourseImp courseImp = new CourseImp();
        if (result.hasErrors()){
            model.addAttribute("newLesson", newLesson);
            model.addAttribute("courses",courseImp.getAll());
            return "/WEB-INF/views/admin/pages/lesson/create_new";
        }else {

            boolean check_insert = lessonImp.create(newLesson);

            if (check_insert==true)
                notification = "Th??m m???i d??? li???u th??nh c??ng !!!";
            else
                notification = "Th??m m???i d??? li???u th???t b???i";
            model.addAttribute("notification", notification);
            model.addAttribute("newLesson", newLesson);
            model.addAttribute("courses",courseImp.getAll());
            return "/WEB-INF/views/admin/pages/lesson/create_new";
        }
    }

    @RequestMapping("init-update")
    public String init_update(@RequestParam("id")int id, Model model){
        IDao courseImp = new CourseImp();
        LessonImp lessonImp = new LessonImp();
        model.addAttribute("old_lesson",lessonImp.findById(id));
        model.addAttribute("courses",courseImp.getAll());
        return "/WEB-INF/views/admin/pages/lesson/update";
    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute("old_lesson")Lesson newLesson, RedirectAttributes redirectAttributes){
        String view,notification;
        LessonImp lessonImp = new LessonImp();
        boolean check_update = lessonImp.update(newLesson);
        if (check_update == true) {
            view = "/admin/lesson";
            notification = "C???p nh???t th??nh c??ng!!";
        } else {
            view = "/admin/lesson/update?id=" + newLesson.getId();
            notification = "C???p nh???t th???t b???i !!!";
        }
        redirectAttributes.addFlashAttribute("notification", notification);
        return "redirect:"+view;
    }

    @RequestMapping(value = "delete")
    public String delete(@RequestParam("id")int id, RedirectAttributes redirectAttributes){
        LessonImp lessonImp = new LessonImp();
        boolean check = lessonImp.delete(id);
        if (check==true)
            redirectAttributes.addFlashAttribute("notification","Xo?? th??nh c??ng");
        else
            redirectAttributes.addFlashAttribute("notification","X??a th???t b???i");
        return "redirect:/admin/lesson/";
    }

    @RequestMapping(value = "search")
    public String search(@RequestParam("key") String keyword, Model model){
        LessonImp lessonImp = new LessonImp();
        List<Lesson> lessonList = lessonImp.searchByName(keyword);
        if (lessonList.size()>0){
            model.addAttribute("notification","???? t??m th???y kh??a h???c c?? t??n l??: " + keyword);
        }else {
            model.addAttribute("notification","R???t ti???c!! Kh??ng gh??? t??m th???y kh??a h???c c?? t??n l: " + keyword);
        }
        model.addAttribute("lesson",lessonList);
        return "/WEB-INF/views/admin/pages/lesson/list_all";
    }
}
