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
                model.addAttribute("blankImg","Vui l??ng ch???n ???nh!!!");
            }

            model.addAttribute("newCourse", newCourse);
            model.addAttribute("category",categoryImp.getAll());
            model.addAttribute("teachers",teacherImp.getAll());
            return "/WEB-INF/views/admin/pages/course/create_new";
        }else {
            if (file != null) {
                try {
                    String filename = file.getOriginalFilename(); // T??n file
                    byte datafile[] = file.getBytes();

                    // 1. Setup t??n file v??o d??? li???u ?????i t?????ng
                    newCourse.setImage(filename); // TODO: n??n ?????i t??n file theo quy t???c (username / email / xyz)
                    String realPath = "C:\\SEMII\\SpringLearning\\Elearning\\src\\main\\webapp\\public\\images";

                    // 2. Upload d??? li???u l??n server
                    // check file ???? t???n t???i hay ch??a
                    File newFile = new File(realPath + "\\" + filename);
                    if (!filename.isEmpty() && newFile.exists()){
                        model.addAttribute("notification","File ???nh n??y ???? t???n t???i");
                        return "/WEB-INF/views/admin/pages/course/create_new";
                    }

                    File fileDestination = new File(realPath + File.separator + filename );
                    Files.write(fileDestination.toPath(), datafile, StandardOpenOption.CREATE_NEW); // Ghi d??? li???u file

                } catch (IOException e) {
                    System.out.println("L???i ?????c file: " + e.getMessage());
                    e.printStackTrace();
                } // D??? li???u file
            }else {
                model.addAttribute("newCourse", newCourse);
                model.addAttribute("category",categoryImp.getAll());
                model.addAttribute("teachers",teacherImp.getAll());
                model.addAttribute("blankImg","Vui l??ng ch???n ???nh!!!");
                return "/WEB-INF/views/admin/pages/course/create_new";
            }
            IDao courseImp = new CourseImp();
            boolean check_insert = courseImp.create(newCourse);

            if (check_insert==true)
                notification = "Th??m m???i d??? li???u th??nh c??ng !!!";
            else
                notification = "Th??m m???i d??? li???u th???t b???i";
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
                filename = file.getOriginalFilename(); // T??n file
                byte datafile[] = file.getBytes();

                // 1. Setup t??n file v??o d??? li???u ?????i t?????ng
                newCourse.setImage(filename); // TODO: n??n ?????i t??n file theo quy t???c (username / email / xyz)
                String realPath = "C:\\SEMII\\SpringLearning\\Elearning\\src\\main\\webapp\\public\\images";

                // 2. Upload d??? li???u l??n server
                // check file ???? t???n t???i hay ch??a
                File newFile = new File(realPath + "\\" + filename);
                if (!filename.isEmpty() && newFile.exists()) {
                    model.addAttribute("notification", "File ???nh n??y ???? t???n t???i");
                    CategoryImp categoryImp = new CategoryImp();
                    TeacherImp teacherImp = new TeacherImp();
                    model.addAttribute("category",categoryImp.getAll());
                    model.addAttribute("teachers",teacherImp.getAll());
                    return "/WEB-INF/views/admin/pages/course/update";
                }

                File fileDestination = new File(realPath + File.separator + filename);
                Files.write(fileDestination.toPath(), datafile, StandardOpenOption.CREATE_NEW); // Ghi d??? li???u file

            } catch (IOException e) {
                System.out.println("L???i ?????c file: " + e.getMessage());
                e.printStackTrace();
            } // D??? li???u file
        }
        CategoryImp categoryImp = new CategoryImp();
        TeacherImp teacherImp = new TeacherImp();
        model.addAttribute("category",categoryImp.getAll());
        model.addAttribute("teachers",teacherImp.getAll());
        IDao courseImp = new CourseImp();
        boolean check_update = courseImp.update(newCourse);
        if (check_update == true) {
            notification = "C???p nh???t th??nh c??ng!!";
        } else {
            notification = "C???p nh???t th???t b???i !!!";
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
            redirectAttributes.addFlashAttribute("notification","Xo?? th??nh c??ng");
        else
            redirectAttributes.addFlashAttribute("notification","X??a th???t b???i");
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
            model.addAttribute("notification","???? t??m th???y kh??a h???c c?? t??n l??: " + keyword);
        }else {
            model.addAttribute("notification","R???t ti???c!! Kh??ng gh??? t??m th???y kh??a h???c c?? t??n l: " + keyword);
        }
        model.addAttribute("course",course);
        return "/WEB-INF/views/admin/pages/course/list_all";
    }
}
