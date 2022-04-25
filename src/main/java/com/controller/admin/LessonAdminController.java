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
                notification = "Thêm mới dữ liệu thành công !!!";
            else
                notification = "Thêm mới dữ liệu thất bại";
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
            notification = "Cập nhật thành công!!";
        } else {
            view = "/admin/lesson/update?id=" + newLesson.getId();
            notification = "Cập nhật thất bại !!!";
        }
        redirectAttributes.addFlashAttribute("notification", notification);
        return "redirect:"+view;
    }

    @RequestMapping(value = "delete")
    public String delete(@RequestParam("id")int id, RedirectAttributes redirectAttributes){
        LessonImp lessonImp = new LessonImp();
        boolean check = lessonImp.delete(id);
        if (check==true)
            redirectAttributes.addFlashAttribute("notification","Xoá thành công");
        else
            redirectAttributes.addFlashAttribute("notification","Xóa thất bại");
        return "redirect:/admin/lesson/";
    }

    @RequestMapping(value = "search")
    public String search(@RequestParam("key") String keyword, Model model){
        LessonImp lessonImp = new LessonImp();
        List<Lesson> lessonList = lessonImp.searchByName(keyword);
        if (lessonList.size()>0){
            model.addAttribute("notification","Đã tìm thấy khóa học có tên là: " + keyword);
        }else {
            model.addAttribute("notification","Rất tiếc!! Không ghể tìm thấy khóa học có tên l: " + keyword);
        }
        model.addAttribute("lesson",lessonList);
        return "/WEB-INF/views/admin/pages/lesson/list_all";
    }
}
