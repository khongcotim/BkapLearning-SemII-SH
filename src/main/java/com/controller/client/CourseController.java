package com.controller.client;

import com.entity.*;
import com.implement.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping(value = "/course.html")
public class CourseController {

    @RequestMapping(value = "")
    public String course(Model model){
        CategoryImp categoryImp = new CategoryImp();
        CourseImp courseImp = new CourseImp();

        List<Category> categories = categoryImp.pagination(0,8);
        HashMap<Integer, List<Course>> cateCouseArr = new HashMap<>();
        categories.forEach(item->{
            cateCouseArr.put(item.getId(),courseImp.findByCate(item.getId()));
        });
        System.out.println(cateCouseArr.get(8));
        model.addAttribute("courseByCate", cateCouseArr);
        model.addAttribute("categories",categories);
        return "WEB-INF/views/client/pages/course";
    }

    @RequestMapping("detail")
    public String course_detail(@RequestParam("id") int courseId, Model model){
        CourseImp courseImp = new CourseImp();
        model.addAttribute("lessons", courseImp.getLessonByCourse(courseId));
        model.addAttribute("detail", courseImp.findById(courseId));
        return "WEB-INF/views/client/pages/course-details";
    }

    @RequestMapping("videos")
    public String videos(@RequestParam("cour_id") int courseId,@RequestParam("id_less") int lessonsId, Model model){
        CourseImp courseImp = new CourseImp();
        LessonImp lessonImp = new LessonImp();
        TestImp testImp = new TestImp();

        Lesson lessonFound = lessonImp.findById(lessonsId);
        Tests testFound = testImp.getTestByLesson(lessonsId);
        String attachment = testFound.getQuestion();
        String typeOfAttach = attachment.substring(attachment.length()-3).toLowerCase(Locale.ROOT);
        System.out.println(typeOfAttach);
        model.addAttribute("courseId", courseId);
        model.addAttribute("lessons", courseImp.getLessonByCourse(courseId));
        model.addAttribute("lessonFound", lessonFound);
        model.addAttribute("testFound", testImp.getTestByLesson(lessonsId));
        model.addAttribute("typeOfAttach", typeOfAttach);

        return "WEB-INF/views/client/pages/course-video";
    }

    @RequestMapping(value = "send-exercise/{testId}", method = RequestMethod.POST)
    public String postExercise(@PathVariable(name = "testId") Integer testId, @RequestParam("file-exc") MultipartFile file, HttpServletRequest request, RedirectAttributes redirectAttributes){
        System.out.println("ajdhjahja");
        Threads newThreads = new Threads();
        TestImp testImp = new TestImp();
        StudentImp studentImp = new StudentImp();
        HttpSession session = request.getSession();

        newThreads.setTests(testImp.findById(testId));
        newThreads.setStudents(studentImp.findByName((String) session.getAttribute("studentName")));
        newThreads.setTests(testImp.findById(testId));

        try {
            String filename = file.getOriginalFilename(); // Tên file
            byte datafile[] = file.getBytes();

            // 1. Setup tên file vào dữ liệu đối tượng
            newThreads.setAnswer_file(filename); // TODO: nên đổi tên file theo quy tắc (username / email / xyz)
            String realPath = "C:\\SEMII\\SpringLearning\\Elearning\\src\\main\\webapp\\public\\answer";

            // 2. Upload dữ liệu lên server
            // check file đã tồn tại hay chưa
            File newFile = new File(realPath + "\\" + filename);

            File fileDestination = new File(realPath + File.separator + filename );
            Files.write(fileDestination.toPath(), datafile, StandardOpenOption.CREATE_NEW); // Ghi dữ liệu file

        } catch (IOException e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
            e.printStackTrace();
        } // Dữ liệu file

        ThreadImp threadImp = new ThreadImp();
        boolean check = threadImp.create(newThreads);
        if (check == true){
            redirectAttributes.addFlashAttribute("notification", "Submit your exercise successful!!!");
        }else {
            redirectAttributes.addFlashAttribute("notification", "Submit your exercise fail!!!");
        }
        String referer = request.getHeader("referer");
        return "redirect:" + referer;
    }
}
