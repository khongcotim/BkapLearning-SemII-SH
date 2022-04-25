package com.controller.admin;

import com.dao.IDao;
import com.entity.Course;
import com.implement.CategoryImp;
import com.implement.CourseImp;
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

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("admin/course")
public class CourseAdminController {

    @RequestMapping(value = {"", "/page/{page}"})
    public String course(@RequestParam(name = "page", required = false) Integer page, Model model){
        IDao courseImp = new CourseImp();
        int itemOnPage = 8;
        int totalEmp = courseImp.selectCount();
        int pages = (int) Math.ceil((double) totalEmp / itemOnPage);
        model.addAttribute("pages", pages);
        if (page == null) {
            page = 0;
        }
        List<Course> courseList = courseImp.pagination(page-1,itemOnPage);
        model.addAttribute("course",courseList);
        return "/WEB-INF/views/admin/pages/course/list_all";
    }

    @RequestMapping("init-insert")
    public String init_insert(Model model){
        CategoryImp categoryImp = new CategoryImp();
        TeacherImp teacherImp = new TeacherImp();
        model.addAttribute("category",categoryImp.getAll());
        model.addAttribute("teachers",teacherImp.getAll());
        model.addAttribute("newCourse",new Course());
        return "/WEB-INF/views/admin/pages/course/create_new";
    }

    @RequestMapping("insert")
    public String insert(@Valid @ModelAttribute("newCourse") Course newCourse, BindingResult result,
                         @RequestParam("fileImg")MultipartFile file,Model model){
        String notification;
        CategoryImp categoryImp = new CategoryImp();
        TeacherImp teacherImp = new TeacherImp();
        if (result.hasErrors()){
            if (file == null){
                model.addAttribute("blankImg","Vui lòng chọn ảnh!!!");
            }

            model.addAttribute("newCourse", newCourse);
            model.addAttribute("category",categoryImp.getAll());
            model.addAttribute("teachers",teacherImp.getAll());
            return "/WEB-INF/views/admin/pages/course/create_new";
        }else {
            if (file != null) {
                try {
                    String filename = file.getOriginalFilename(); // Tên file
                    byte datafile[] = file.getBytes();

                    // 1. Setup tên file vào dữ liệu đối tượng
                    newCourse.setImage(filename); // TODO: nên đổi tên file theo quy tắc (username / email / xyz)
                    String realPath = "C:\\SEMII\\SpringLearning\\Elearning\\src\\main\\webapp\\public\\images";

                    // 2. Upload dữ liệu lên server
                    // check file đã tồn tại hay chưa
                    File newFile = new File(realPath + "\\" + filename);
                    if (!filename.isEmpty() && newFile.exists()){
                        model.addAttribute("notification","File ảnh này đã tồn tại");
                        return "/WEB-INF/views/admin/pages/course/create_new";
                    }

                    File fileDestination = new File(realPath + File.separator + filename );
                    Files.write(fileDestination.toPath(), datafile, StandardOpenOption.CREATE_NEW); // Ghi dữ liệu file

                } catch (IOException e) {
                    System.out.println("Lỗi đọc file: " + e.getMessage());
                    e.printStackTrace();
                } // Dữ liệu file
            }else {
                model.addAttribute("newCourse", newCourse);
                model.addAttribute("category",categoryImp.getAll());
                model.addAttribute("teachers",teacherImp.getAll());
                model.addAttribute("blankImg","Vui lòng chọn ảnh!!!");
                return "/WEB-INF/views/admin/pages/course/create_new";
            }
            IDao courseImp = new CourseImp();
            boolean check_insert = courseImp.create(newCourse);

            if (check_insert==true)
                notification = "Thêm mới dữ liệu thành công !!!";
            else
                notification = "Thêm mới dữ liệu thất bại";
            model.addAttribute("notification",notification);
            model.addAttribute("newCourse", newCourse);
            model.addAttribute("category",categoryImp.getAll());
            model.addAttribute("teachers",teacherImp.getAll());
            return "/WEB-INF/views/admin/pages/course/create_new";
        }
    }

    @RequestMapping("init-update")
    public String init_update(@RequestParam("id")int id, Model model){
        IDao courseImp = new CourseImp();
        CategoryImp categoryImp = new CategoryImp();
        TeacherImp teacherImp = new TeacherImp();
        model.addAttribute("old_course",courseImp.findById(id));
        model.addAttribute("category",categoryImp.getAll());
        model.addAttribute("teachers",teacherImp.getAll());
        return "/WEB-INF/views/admin/pages/course/update";
    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute("old_course")Course newCourse,BindingResult result,
                        @RequestParam("fileImg")MultipartFile file,
                         Model model, RedirectAttributes redirectAttributes){
        String view,notification, filename = null;
        if (file.getOriginalFilename().length()==0) {
            CourseImp newCourseImp = new CourseImp();
            model.addAttribute("old_course",newCourse);
            newCourse.setImage(newCourseImp.findById(newCourse.getId()).getImage());
            filename = "";
        }else if(file!= null){
            try {
                filename = file.getOriginalFilename(); // Tên file
                byte datafile[] = file.getBytes();

                // 1. Setup tên file vào dữ liệu đối tượng
                newCourse.setImage(filename); // TODO: nên đổi tên file theo quy tắc (username / email / xyz)
                String realPath = "C:\\SEMII\\SpringLearning\\Elearning\\src\\main\\webapp\\public\\images";

                // 2. Upload dữ liệu lên server
                // check file đã tồn tại hay chưa
                File newFile = new File(realPath + "\\" + filename);
                if (!filename.isEmpty() && newFile.exists()) {
                    model.addAttribute("notification", "File ảnh này đã tồn tại");
                    CategoryImp categoryImp = new CategoryImp();
                    TeacherImp teacherImp = new TeacherImp();
                    model.addAttribute("category",categoryImp.getAll());
                    model.addAttribute("teachers",teacherImp.getAll());
                    return "/WEB-INF/views/admin/pages/course/update";
                }

                File fileDestination = new File(realPath + File.separator + filename);
                Files.write(fileDestination.toPath(), datafile, StandardOpenOption.CREATE_NEW); // Ghi dữ liệu file

            } catch (IOException e) {
                System.out.println("Lỗi đọc file: " + e.getMessage());
                e.printStackTrace();
            } // Dữ liệu file
        }
        CategoryImp categoryImp = new CategoryImp();
        TeacherImp teacherImp = new TeacherImp();
        model.addAttribute("category",categoryImp.getAll());
        model.addAttribute("teachers",teacherImp.getAll());
        IDao courseImp = new CourseImp();
        boolean check_update = courseImp.update(newCourse);
        if (check_update == true) {
            notification = "Cập nhật thành công!!";
        } else {
            notification = "Cập nhật thất bại !!!";
        }
        view = "/admin/course";
        redirectAttributes.addFlashAttribute("notification", notification);
        return "redirect:"+view;
    }

    @RequestMapping(value = "delete")
    public String delete(@RequestParam("id")int id, RedirectAttributes redirectAttributes){
       IDao courseImp = new CourseImp();
        boolean check = courseImp.delete(id);
        if (check==true)
            redirectAttributes.addFlashAttribute("notification","Xoá thành công");
        else
            redirectAttributes.addFlashAttribute("notification","Xóa thất bại");
        return "redirect:/admin/course";
    }

    @RequestMapping(value = "detail")
    public String detail(@RequestParam("id")int id, Model model){
        IDao courseImp = new CourseImp();
        model.addAttribute("course_found",courseImp.findById(id));
        return "/WEB-INF/views/admin/pages/course/detail";
    }

    @RequestMapping(value = "search")
    public String search(@RequestParam("key") String keyword, Model model){
        CourseImp courseImp = new CourseImp();
        List<Course> course = courseImp.searchByName(keyword);
        if (course!= null){
            model.addAttribute("notification","Đã tìm thấy khóa học có tên là: " + keyword);
        }else {
            model.addAttribute("notification","Rất tiếc!! Không ghể tìm thấy khóa học có tên l: " + keyword);
        }
        model.addAttribute("course",course);
        return "/WEB-INF/views/admin/pages/course/list_all";
    }
}
