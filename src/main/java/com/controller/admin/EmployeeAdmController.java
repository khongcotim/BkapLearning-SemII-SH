package com.controller.admin;

import com.dao.IDao;
import com.entity.Course;
import com.entity.Employee;
import com.entity.Students;
import com.implement.CourseImp;
import com.implement.EmployeeImp;
import com.implement.StudentImp;
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
@RequestMapping("admin/employee-manage")
public class EmployeeAdmController {
    @RequestMapping(value = {"","/page/{page}"})
    public String index(@RequestParam(name = "page",required = false) Integer page, Model model){
        IDao employeeImp = new EmployeeImp();
        int itemOnPage = 8;
        int totalEmp = employeeImp.selectCount();
        int pages = (int) Math.ceil((double) totalEmp / itemOnPage);
        model.addAttribute("pages", pages);

        if (page == null) {
            page = 0;
        }

        List<Employee> employeeList =  employeeImp.pagination(page-1, itemOnPage); // empDAO.select();
        model.addAttribute("employee",employeeList);
        return "WEB-INF/views/admin/pages/employee/list_all";
    }

    @RequestMapping("init-insert")
    public String init_insert(Model model){
        model.addAttribute("newEmployee",new Employee());
        return "WEB-INF/views/admin/pages/employee/create_new";
    }

    @RequestMapping(value = "insert",method = RequestMethod.POST)
    public String insert(@Valid @ModelAttribute("newEmployee") Employee newEmployee, BindingResult result,
                         @RequestParam("avatarName") MultipartFile file, Model model){
        String notification;
        if (result.hasErrors()){
            model.addAttribute("newEmployee", newEmployee);
            return "/WEB-INF/views/admin/pages/employee/create_new";
        }else {
            System.out.println("result not err!!");
            if (file != null) {
                System.out.println("result not err && have file!!");

                try {
                    String filename = file.getOriginalFilename(); // T??n file
                    byte datafile[] = file.getBytes();

                    // 1. Setup t??n file v??o d??? li???u ?????i t?????ng
                    newEmployee.setAvatar(filename); // TODO: n??n ?????i t??n file theo quy t???c (username / email / xyz)
                    String realPath = "C:\\SEMII\\SpringLearning\\Elearning\\src\\main\\webapp\\public\\images\\employee";
                    // 2. Upload d??? li???u l??n server
                    // check file ???? t???n t???i hay ch??a
                    File newFile = new File(realPath + "\\" + filename);
                    if (!filename.isEmpty() && newFile.exists()) {
                        model.addAttribute("notification", "File ???nh n??y ???? t???n t???i");
                        return "/WEB-INF/views/admin/pages/employee/create_new";
                    }

                    File fileDestination = new File(realPath + File.separator + filename);
                    Files.write(fileDestination.toPath(), datafile, StandardOpenOption.CREATE_NEW); // Ghi d??? li???u file

                } catch (IOException e) {
                    System.out.println("L???i ?????c file: " + e.getMessage());
                    e.printStackTrace();
                } // D??? li???u file
            } else {
                System.out.println("result not err & not have file!!");
                model.addAttribute("newEmployee", newEmployee);
                model.addAttribute("notification", "Vui l??ng ch???n ???nh!!!");
                return "/WEB-INF/views/admin/pages/employee/create_new";
            }
            IDao employeeImp = new EmployeeImp();
            boolean check_insert = employeeImp.create(newEmployee);

            if (check_insert==true)
                notification = "Th??m m???i d??? li???u th??nh c??ng !!!";
            else
                notification = "Th??m m???i d??? li???u th???t b???i";
            model.addAttribute("notification",notification);
            return "/WEB-INF/views/admin/pages/employee/create_new";
        }
    }

    @RequestMapping("init-update")
    public String init_update(@RequestParam("id")int id, Model model){
        IDao employeeImp = new EmployeeImp();
        model.addAttribute("oldEmployee",employeeImp.findById(id));
        return "WEB-INF/views/admin/pages/employee/update";
    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute("oldEmployee")Employee newEmployee, BindingResult result,
                         @RequestParam("avatarName") MultipartFile file,Model model, RedirectAttributes redirectAttributes){
        String view,notification = null, filename = null;
        if (result.hasErrors()){
            model.addAttribute("oldEmployee",newEmployee);
            view = "admin/employee-manage/update?id="+ newEmployee.getId();
        }else{
            if (file.getOriginalFilename().length()==0) {
                StudentImp studentImp = new StudentImp();
                model.addAttribute("oldEmployee",newEmployee);
                newEmployee.setAvatar(studentImp.findById(newEmployee.getId()).getAvatar());
                filename = "";
            }else if(file!= null){
                try {
                    filename = file.getOriginalFilename(); // T??n file
                    byte datafile[] = file.getBytes();

                    // 1. Setup t??n file v??o d??? li???u ?????i t?????ng
                    newEmployee.setAvatar(filename); // TODO: n??n ?????i t??n file theo quy t???c (username / email / xyz)
                    String realPath = "C:\\SEMII\\SpringLearning\\Elearning\\src\\main\\webapp\\public\\images\\employee";

                    // 2. Upload d??? li???u l??n server
                    // check file ???? t???n t???i hay ch??a
                    File newFile = new File(realPath + "\\" + filename);
                    if (!filename.isEmpty() && newFile.exists()) {
                        model.addAttribute("oldEmployee",newEmployee);
                        model.addAttribute("notification", "File ???nh n??y ???? t???n t???i");
                        return "WEB-INF/views/admin/pages/employee/update";
                    }

                    File fileDestination = new File(realPath + File.separator + filename);
                    Files.write(fileDestination.toPath(), datafile, StandardOpenOption.CREATE_NEW); // Ghi d??? li???u file

                } catch (IOException e) {
                    System.out.println("L???i ?????c file: " + e.getMessage());
                    e.printStackTrace();
                } // D??? li???u file
            }
            IDao employeeImp = new EmployeeImp();
            boolean check_update = employeeImp.update(newEmployee);
            if (check_update == true){
                notification = "C???p nh???t th??nh c??ng!!";
            }else {
                notification = "C???p nh???t th???t b???i !!!";
            }
            view = "/admin/employee-manage";
        }
        redirectAttributes.addFlashAttribute("notification", notification);
        return "redirect:"+view;
    }

    @RequestMapping(value = "delete")
    public String delete(@RequestParam("id")int id, RedirectAttributes redirectAttributes){
        IDao employeeImp = new EmployeeImp();
        boolean check = employeeImp.delete(id);
        if (check==true)
            redirectAttributes.addFlashAttribute("notification","Xo?? th??nh c??ng");
        else
            redirectAttributes.addFlashAttribute("notification","X??a th???t b???i");
        return "redirect:/admin/employee-manage";
    }

    @RequestMapping(value = "detail")
    public String detail(@RequestParam("id")int id, Model model){
        IDao employeeImp = new EmployeeImp();
        model.addAttribute("course_found",employeeImp.findById(id));
        return "WEB-INF/views/admin/pages/employee/detail";
    }

    @RequestMapping(value = "search")
    public String search(@RequestParam("key") String keyword, Model model){
        EmployeeImp employeeImp = new EmployeeImp();
        List<Employee> employeeList = employeeImp.searchByName(keyword);
        if (employeeList.size()>0){
            model.addAttribute("notification","???? t??m th???y nh??n vi??n c?? t??n l??: " + keyword);
        }else {
            model.addAttribute("notification","R???t ti???c!! Kh??ng gh??? t??m th???y nh??n vi??n c?? t??n l: " + keyword);
        }
        model.addAttribute("employee",employeeList);
        return "/WEB-INF/views/admin/pages/employee/list_all";
    }
}
