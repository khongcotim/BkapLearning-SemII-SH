package com.controller.admin;

import com.dao.IDao;
import com.entity.Students;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("admin/students-manage")
public class StudentManageController {
    @RequestMapping(value = {"","/page/{page}"})
    public String index(@RequestParam(name = "page",required = false) Integer page,  Model model){
        IDao studentImp = new StudentImp();
        int itemOnPage = 8;
        int totalEmp = studentImp.selectCount();
        int pages = (int) Math.ceil((double) totalEmp / itemOnPage);
        model.addAttribute("pages", pages);

        if (page == null) {
            page = 0;
        }

        List<Students> studentsList =  studentImp.pagination(page-1, itemOnPage); // empDAO.select();
        model.addAttribute("students",studentsList);
        return "WEB-INF/views/admin/pages/students/list_all";
    }

    @RequestMapping("init-insert")
    public String init_insert(Model model){
        model.addAttribute("newStudent",new Students());
        return "WEB-INF/views/admin/pages/students/create_new";
    }

    @RequestMapping(value = "insert",method = RequestMethod.POST)
    public String insert(@Valid @ModelAttribute("newStudent") Students newStudent, BindingResult result, Model model){
        String notification;
        if (result.hasErrors()){
            model.addAttribute("newStudent", newStudent);
            return "WEB-INF/views/admin/pages/students/create_new";
        }else {
            IDao studentImp = new StudentImp();
            boolean check_insert = studentImp.create(newStudent);

            if (check_insert==true)
                notification = "Thêm mới dữ liệu thành công !!!";
            else
                notification = "Thêm mới dữ liệu thất bại";
            model.addAttribute("notification",notification);
            return "WEB-INF/views/admin/pages/students/create_new";
        }
    }

    @RequestMapping("init-update")
    public String init_update(@RequestParam("id")int id, Model model){
        IDao studentImp = new StudentImp();
        model.addAttribute("old_student",studentImp.findById(id));
        return "WEB-INF/views/admin/pages/students/update";
    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute("old_student")Students newStudent, BindingResult result, Model model, RedirectAttributes redirectAttributes){
        String view,notification = null;
        if (result.hasErrors()){
            model.addAttribute("old_student",newStudent);
            view = "admin/students-manage/update?id="+ newStudent.getId();
        }else{
            IDao studentImp = new StudentImp();
            boolean check_update = studentImp.update(newStudent);
            if (check_update == true){
                notification = "Cập nhật thành công!!";
            }else {
               notification = "Cập nhật thất bại !!!";
            }
            view = "/admin/students-manage";
        }
        redirectAttributes.addFlashAttribute("notification", notification);
        return "redirect:"+view;
    }

    @RequestMapping(value = "delete")
    public String delete(@RequestParam("id")int id, RedirectAttributes redirectAttributes){
        IDao studentImp = new StudentImp();
        boolean check = studentImp.delete(id);
        if (check==true)
            redirectAttributes.addFlashAttribute("notification","Xoá thành công");
        else
            redirectAttributes.addFlashAttribute("notification","Xóa thất bại");
        return "redirect:/admin/students-manage";
    }

    @RequestMapping(value = "detail")
    public String detail(@RequestParam("id")int id, Model model){
        IDao studentImp = new StudentImp();
        model.addAttribute("course_found",studentImp.findById(id));
        return "WEB-INF/views/admin/pages/students/detail";
    }

    @RequestMapping(value = "search")
    public String search(@RequestParam("key") String keyword, Model model){
        StudentImp studentImp = new StudentImp();
        List<Students> studentsList = studentImp.searchByName(keyword);
        if (studentsList.size()>0){
            model.addAttribute("notification","Đã tìm thấy học sinh có tên là: " + keyword);
        }else {
            model.addAttribute("notification","Rất tiếc!! Không ghể tìm thấy học sinh có tên l: " + keyword);
        }
        model.addAttribute("students",studentsList);
        return "/WEB-INF/views/admin/pages/students/list_all";
    }
}
