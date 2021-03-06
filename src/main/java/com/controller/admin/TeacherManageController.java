package com.controller.admin;

import com.dao.IDao;
import com.entity.Category;
import com.entity.Students;
import com.entity.Teachers;
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
import java.util.List;

@Controller
@RequestMapping("admin/teacher-manage")
public class TeacherManageController {
    @RequestMapping(value = {"","/page/{page}"})
    public String index(@RequestParam(name = "page", required = false) Integer page,  Model model){
        IDao teacherImp = new TeacherImp();
        int itemOnPage = 8;
        int totalEmp = teacherImp.selectCount();
        int pages = (int) Math.ceil((double) totalEmp / itemOnPage);

        model.addAttribute("pages", pages);
        if (page == null) {
            page = 0;
        }

        List<Teachers> teachers =  teacherImp.pagination(page-1, itemOnPage); // empDAO.select();
        model.addAttribute("teachers",teachers);
        return "WEB-INF/views/admin/pages/teacher/list_all";
    }

    @RequestMapping("init-insert")
    public String init_insert(Model model){
        model.addAttribute("newTeacher",new Teachers());
        return "WEB-INF/views/admin/pages/teacher/create_new";
    }

    @RequestMapping(value = "insert",method = RequestMethod.POST)
    public String insert(@Valid @ModelAttribute("newTeacher") Teachers newTeacher, BindingResult result,
                         @RequestParam("avatarName") MultipartFile file, Model model){
        String notification;
        if (result.hasErrors()){
            model.addAttribute("newTeacher", newTeacher);
            return "/WEB-INF/views/admin/pages/teacher/create_new";
        }else {
            System.out.println("result not err!!");
            if (file != null) {
                System.out.println("result not err && have file!!");

                try {
                    String filename = file.getOriginalFilename(); // T??n file
                    byte datafile[] = file.getBytes();

                    // 1. Setup t??n file v??o d??? li???u ?????i t?????ng
                    newTeacher.setAvatar(filename); // TODO: n??n ?????i t??n file theo quy t???c (username / email / xyz)
                    String realPath = "C:\\SEMII\\SpringLearning\\Elearning\\src\\main\\webapp\\public\\images\\teachers";
                    // 2. Upload d??? li???u l??n server
                    // check file ???? t???n t???i hay ch??a
                    File newFile = new File(realPath + "\\" + filename);
                    if (!filename.isEmpty() && newFile.exists()) {
                        model.addAttribute("notification", "File ???nh n??y ???? t???n t???i");
                        return "/WEB-INF/views/admin/pages/teacher/create_new";
                    }

                    File fileDestination = new File(realPath + File.separator + filename);
                    Files.write(fileDestination.toPath(), datafile, StandardOpenOption.CREATE_NEW); // Ghi d??? li???u file

                } catch (IOException e) {
                    System.out.println("L???i ?????c file: " + e.getMessage());
                    e.printStackTrace();
                } // D??? li???u file
            } else {
                System.out.println("result not err & not have file!!");
                model.addAttribute("newTeacher", newTeacher);
                model.addAttribute("notification", "Vui l??ng ch???n ???nh!!!");
                return "WEB-INF/views/admin/pages/teacher/create_new";
            }
            
            IDao teacherImp = new TeacherImp();
            boolean check_insert = teacherImp.create(newTeacher);

            if (check_insert==true)
                notification = "Th??m m???i d??? li???u th??nh c??ng !!!";
            else
                notification = "Th??m m???i d??? li???u th???t b???i";
            model.addAttribute("notification",notification);
            return "WEB-INF/views/admin/pages/teacher/create_new";
        }
    }

    @RequestMapping("init-update")
    public String init_update(@RequestParam("id")int id, Model model){
        IDao teacherImp = new TeacherImp();
        model.addAttribute("old_teacher",teacherImp.findById(id));
        return "WEB-INF/views/admin/pages/teacher/update";
    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute("old_teacher")Teachers newTeacher, BindingResult result, Model model,
                         @RequestParam("avatarName") MultipartFile file,RedirectAttributes redirectAttributes){
        String view,notification = null,filename = null;
        if (result.hasErrors()){
            model.addAttribute("old_teacher",newTeacher);
            view = "admin/teacher-manage/update?id="+ newTeacher.getId();
        }else{
            if (file.getOriginalFilename().length()==0) {
                StudentImp studentImp = new StudentImp();
                model.addAttribute("old_teacher",newTeacher);
                newTeacher.setAvatar(studentImp.findById(newTeacher.getId()).getAvatar());
                filename = "";
            }else if(file!= null){
                try {
                    filename = file.getOriginalFilename(); // T??n file
                    byte datafile[] = file.getBytes();

                    // 1. Setup t??n file v??o d??? li???u ?????i t?????ng
                    newTeacher.setAvatar(filename); // TODO: n??n ?????i t??n file theo quy t???c (username / email / xyz)
                    String realPath = "C:\\SEMII\\SpringLearning\\Elearning\\src\\main\\webapp\\public\\images\\teachers";

                    // 2. Upload d??? li???u l??n server
                    // check file ???? t???n t???i hay ch??a
                    File newFile = new File(realPath + "\\" + filename);
                    if (!filename.isEmpty() && newFile.exists()) {
                        model.addAttribute("notification", "File ???nh n??y ???? t???n t???i");
                        CategoryImp categoryImp = new CategoryImp();
                        IDao teacherImp = new TeacherImp();
                        model.addAttribute("category",categoryImp.getAll());
                        model.addAttribute("teachers",teacherImp.getAll());
                        return "/WEB-INF/views/admin/pages/teacher/update";
                    }

                    File fileDestination = new File(realPath + File.separator + filename);
                    Files.write(fileDestination.toPath(), datafile, StandardOpenOption.CREATE_NEW); // Ghi d??? li???u file

                } catch (IOException e) {
                    System.out.println("L???i ?????c file: " + e.getMessage());
                    e.printStackTrace();
                } // D??? li???u file
            }
            IDao teacherImp = new TeacherImp();
            boolean check_update = teacherImp.update(newTeacher);
            if (check_update == true){
                notification = "C???p nh???t th??nh c??ng!!";
            }else {
               notification = "C???p nh???t th???t b???i !!!";
            }
            view = "/admin/teacher-manage";
        }
        redirectAttributes.addFlashAttribute("notification", notification);
        return "redirect:"+view;
    }

    @RequestMapping(value = "delete")
    public String delete(@RequestParam("id")int id, RedirectAttributes redirectAttributes){
        IDao teacherImp = new TeacherImp();

        boolean check = teacherImp.delete(id);
        if (check==true)
            redirectAttributes.addFlashAttribute("notification","Xo?? th??nh c??ng");
        else
            redirectAttributes.addFlashAttribute("notification","X??a th???t b???i");
        return "redirect:/admin/teacher-manage";
    }

    @RequestMapping(value = "detail")
    public String detail(@RequestParam("id")int id, Model model){
        CourseImp courseImp = new CourseImp();
        model.addAttribute("teacher_found",courseImp.findById(id));
        return "WEB-INF/views/admin/pages/teacher/detail";
    }

    @RequestMapping(value = "search")
    public String search(@RequestParam("key") String keyword, Model model){
        TeacherImp teacherImp = new TeacherImp();
        List<Teachers> teachers = teacherImp.searchByName(keyword);
        if (teachers.size()>0){
            model.addAttribute("notification","???? t??m th???y kh??a h???c c?? t??n l??: " + keyword);
        }else {
            model.addAttribute("notification","R???t ti???c!! Kh??ng gh??? t??m th???y kh??a h???c c?? t??n l: " + keyword);
        }
        model.addAttribute("teachers",teachers);
        return "/WEB-INF/views/admin/pages/teacher/list_all";
    }
}
