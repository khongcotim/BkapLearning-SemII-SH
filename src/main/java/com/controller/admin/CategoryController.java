package com.controller.admin;

import com.dao.IDao;
import com.entity.Category;
import com.implement.CategoryImp;
import com.implement.TeacherImp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;

@Controller
@RequestMapping("admin/category")
public class CategoryController {
    @RequestMapping(value = { "", "/page/{page}" })
    public String category(@PathVariable(name = "page", required = false) Integer page, Model  model){

        IDao categoryImp = new CategoryImp();
        int itemOnPage = 8;
        int totalEmp = categoryImp.selectCount();
        int pages = (int) Math.ceil((double) totalEmp / itemOnPage);
        model.addAttribute("pages", pages);

        if (page == null) {
            page = 0;
        }

        List<Category> categoryList =  categoryImp.pagination(page-1, itemOnPage); // empDAO.select();
        int current_page = page;

        model.addAttribute("current_page", current_page);
        model.addAttribute("category",categoryList);
        return "WEB-INF/views/admin/pages/category/list_all";
    }

    @RequestMapping("init-insert")
    public String init_ínert(Model model){
        IDao categoryImp = new CategoryImp();
        model.addAttribute("newCate",new Category());
        return "WEB-INF/views/admin/pages/category/create_new";
    }

    @RequestMapping("insert")
    public String insert(@Valid @ModelAttribute("newCate") Category category, BindingResult result, @RequestParam("fileImg") MultipartFile file, Model model){
        String notification;
        if (result.hasErrors()){
            model.addAttribute("newCate", category);
            return "WEB-INF/views/admin/pages/category/create_new";
        }else {
            if (file != null) {
                try {
                    String filename = file.getOriginalFilename(); // Tên file
                    byte datafile[] = file.getBytes();

                    // 1. Setup tên file vào dữ liệu đối tượng
                    category.setAvatar(filename); // TODO: nên đổi tên file theo quy tắc (username / email / xyz)
                    String realPath = "C:\\SEMII\\SpringLearning\\Elearning\\src\\main\\webapp\\public\\images";

                    // 2. Upload dữ liệu lên server
                    // check file đã tồn tại hay chưa
                    File newFile = new File(realPath + "\\" + filename);
                    if (!filename.isEmpty() && newFile.exists()){
                        model.addAttribute("notification","File ảnh này đã tồn tại");
                        return "/WEB-INF/views/admin/pages/category/create_new";
                    }

                    File fileDestination = new File(realPath + File.separator + filename );
                    Files.write(fileDestination.toPath(), datafile, StandardOpenOption.CREATE_NEW); // Ghi dữ liệu file

                } catch (IOException e) {
                    System.out.println("Lỗi đọc file: " + e.getMessage());
                    e.printStackTrace();
                } // Dữ liệu file
            }else {
                model.addAttribute("newCate", category);
                model.addAttribute("blankImg","Vui lòng chọn ảnh!!!");
                return "/WEB-INF/views/admin/pages/category/create_new";
            }
            IDao categoryImp = new CategoryImp();
            boolean check_insert = categoryImp.create(category);

            if (check_insert==true)
                notification = "Thêm mới dữ liệu thành công !!!";
            else
                notification = "Thêm mới dữ liệu thất bại";
            model.addAttribute("notification",notification);
            return "WEB-INF/views/admin/pages/category/create_new";
        }
    }

    @RequestMapping("init-update")
    public String init_update(@RequestParam("id")int id, Model model){
        IDao categoryImp = new CategoryImp();
        model.addAttribute("old_cate",categoryImp.findById(id));
        return "WEB-INF/views/admin/pages/category/update";
    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute("old_cate")Category newCate, BindingResult result,@RequestParam("fileImg")MultipartFile file, Model model, RedirectAttributes redirectAttributes){
        String view,notification = null,filename = null;
        if (result.hasErrors()){
            model.addAttribute("old_cate",newCate);
            view = "admin/category/update?id="+newCate.getId();
        }else{
            if (file.getOriginalFilename().length()==0) {
                CategoryImp categoryImp = new CategoryImp();
                model.addAttribute("old_cate",newCate);
                newCate.setAvatar(categoryImp.findById(newCate.getId()).getAvatar());
                filename = "";
            }else if(file!= null){
                try {
                    filename = file.getOriginalFilename(); // Tên file
                    byte datafile[] = file.getBytes();

                    // 1. Setup tên file vào dữ liệu đối tượng
                    newCate.setAvatar(filename); // TODO: nên đổi tên file theo quy tắc (username / email / xyz)
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
                        return "/WEB-INF/views/admin/pages/category/update";
                    }

                    File fileDestination = new File(realPath + File.separator + filename);
                    Files.write(fileDestination.toPath(), datafile, StandardOpenOption.CREATE_NEW); // Ghi dữ liệu file

                } catch (IOException e) {
                    System.out.println("Lỗi đọc file: " + e.getMessage());
                    e.printStackTrace();
                } // Dữ liệu file
            }
            IDao categoryImp = new CategoryImp();
            boolean check_update = categoryImp.update(newCate);
            if (check_update == true){
                notification = "Cập nhật thành công!!";
            }else {
               notification = "Cập nhật thất bại !!!";
            }
            view = "/admin/category";
        }
        redirectAttributes.addFlashAttribute("notification", notification);
        return "redirect:"+view;
    }

    @RequestMapping(value = "delete")
    public String delete(@RequestParam("id")int id, RedirectAttributes redirectAttributes){
        IDao categoryImp = new CategoryImp();
        boolean check = categoryImp.delete(id);
        if (check==true)
            redirectAttributes.addFlashAttribute("notification","Xoá thành công");
        else
            redirectAttributes.addFlashAttribute("notification","Xóa thất bại");
        return "redirect:/admin/category";
    }

    @RequestMapping(value = "search")
    public String search(@RequestParam("key") String keyword, Model model){
        CategoryImp categoryImp = new CategoryImp();
        List<Category> categories = categoryImp.searchByName(keyword);
        if (categories.size()>0){
            model.addAttribute("notification","Đã tìm thấy danh mục có tên là: " + keyword);
        }else {
            model.addAttribute("notification","Rất tiếc!! Không ghể tìm thấy danh mục có tên l: " + keyword);
        }
        model.addAttribute("category",categories);
        return "/WEB-INF/views/admin/pages/category/list_all";
    }
}