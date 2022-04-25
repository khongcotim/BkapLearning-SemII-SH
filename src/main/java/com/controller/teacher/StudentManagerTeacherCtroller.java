package com.controller.teacher;

import com.dao.IDao;
import com.entity.Students;
import com.implement.CategoryImp;
import com.implement.CourseImp;
import com.implement.StudentImp;
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

@Controller
@RequestMapping("teacher/student-manage")
public class StudentManagerTeacherCtroller {
    @RequestMapping("")
    public String index(Model model) {
        IDao studentImp = new StudentImp();
        model.addAttribute("students", studentImp.getAll());
        return "/WEB-INF/views/teacher/pages/students/list_all";
    }

    @RequestMapping("init-insert")
    public String init_insert(Model model) {
        model.addAttribute("newStudent", new Students());
        return "/WEB-INF/views/teacher/pages/students/create_new";
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String insert(@Valid @ModelAttribute("newStudent") Students newStudent, BindingResult result,
                         @RequestParam("avatarName") MultipartFile file, Model model) {
        String notification;
        if (result.hasErrors()) {
            System.out.println(result.getFieldError());
            System.out.println(newStudent.toString());
            System.out.println("result has err");
            model.addAttribute("newStudent", newStudent);
            return "/WEB-INF/views/teacher/pages/students/create_new";
        } else {
            System.out.println("result not err!!");
            if (file != null) {
                System.out.println("result not err && have file!!");

                try {
                    String filename = file.getOriginalFilename(); // Tên file
                    byte datafile[] = file.getBytes();

                    // 1. Setup tên file vào dữ liệu đối tượng
                    newStudent.setAvatar(filename); // TODO: nên đổi tên file theo quy tắc (username / email / xyz)
                    String realPath = "C:\\SEMII\\SpringLearning\\Elearning\\src\\main\\webapp\\public\\images\\students";
                    // 2. Upload dữ liệu lên server
                    // check file đã tồn tại hay chưa
                    File newFile = new File(realPath + "\\" + filename);
                    if (!filename.isEmpty() && newFile.exists()) {
                        model.addAttribute("notification", "File ảnh này đã tồn tại");
                        return "/WEB-INF/views/teacher/pages/students/create_new";
                    }

                    File fileDestination = new File(realPath + File.separator + filename);
                    Files.write(fileDestination.toPath(), datafile, StandardOpenOption.CREATE_NEW); // Ghi dữ liệu file

                } catch (IOException e) {
                    System.out.println("Lỗi đọc file: " + e.getMessage());
                    e.printStackTrace();
                } // Dữ liệu file
            } else {
                System.out.println("result not err & not have file!!");
                model.addAttribute("old_student", newStudent);
                model.addAttribute("notification", "Vui lòng chọn ảnh!!!");
                return "/WEB-INF/views/teacher/pages/students/create_new";
            }
            IDao studentImp = new StudentImp();
            boolean check_insert = studentImp.create(newStudent);

            if (check_insert == true)
                notification = "Thêm mới dữ liệu thành công !!!";
            else
                notification = "Thêm mới dữ liệu thất bại";
            model.addAttribute("notification", notification);
            return "/WEB-INF/views/teacher/pages/students/create_new";
        }
    }

    @RequestMapping("init-update")
    public String init_update(@RequestParam("id") int id, Model model) {
        IDao studentImp = new StudentImp();
        model.addAttribute("old_student", studentImp.findById(id));
        return "/WEB-INF/views/teacher/pages/students/update";
    }

    @RequestMapping(value = "update")
    public String update(@Valid @ModelAttribute("old_student") Students newStudent, BindingResult result,
                         @RequestParam("avatarName") MultipartFile file, Model model, RedirectAttributes redirectAttributes) {
        String view, notification = null,filename = null;
        if (result.hasErrors()) {
            model.addAttribute("old_student", newStudent);
            view = "/teacher/student-manage/update?id=" + newStudent.getId();
        } else {
            if (file.getOriginalFilename().length()==0) {
                StudentImp studentImp = new StudentImp();
                model.addAttribute("old_student",newStudent);
                newStudent.setAvatar(studentImp.findById(newStudent.getId()).getAvatar());
                filename = "";
            }else if(file!= null){
                try {
                    filename = file.getOriginalFilename(); // Tên file
                    byte datafile[] = file.getBytes();

                    // 1. Setup tên file vào dữ liệu đối tượng
                    newStudent.setAvatar(filename); // TODO: nên đổi tên file theo quy tắc (username / email / xyz)
                    String realPath = "C:\\SEMII\\SpringLearning\\Elearning\\src\\main\\webapp\\public\\images\\students";

                    // 2. Upload dữ liệu lên server
                    // check file đã tồn tại hay chưa
                    File newFile = new File(realPath + "\\" + filename);
                    if (!filename.isEmpty() && newFile.exists()) {
                        model.addAttribute("notification", "File ảnh này đã tồn tại");
                        CategoryImp categoryImp = new CategoryImp();
                        TeacherImp teacherImp = new TeacherImp();
                        model.addAttribute("category",categoryImp.getAll());
                        model.addAttribute("teachers",teacherImp.getAll());
                        return "/WEB-INF/views/teacher/pages/students/update";
                    }

                    File fileDestination = new File(realPath + File.separator + filename);
                    Files.write(fileDestination.toPath(), datafile, StandardOpenOption.CREATE_NEW); // Ghi dữ liệu file

                } catch (IOException e) {
                    System.out.println("Lỗi đọc file: " + e.getMessage());
                    e.printStackTrace();
                } // Dữ liệu file
            }
            IDao studentImp = new StudentImp();
            boolean check_update = studentImp.update(newStudent);
            if (check_update == true) {
                notification = "Cập nhật thành công!!";
            } else {
                notification = "Cập nhật thất bại !!!";
            }
            view = "/teacher/student-manage";
        }
        redirectAttributes.addFlashAttribute("notification", notification);
        return "redirect:" + view;
    }

    @RequestMapping(value = "detail")
    public String detail(@RequestParam("id") int id, Model model) {
        CourseImp courseImp = new CourseImp();
        model.addAttribute("course_found", courseImp.findById(id));
        return "/WEB-INF/views/teacher/pages/students/detail";
    }
}
