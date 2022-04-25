package com.controller.teacher;

import com.entity.Course;
import com.entity.Lesson;
import com.entity.Teachers;
import com.entity.Tests;
import com.implement.CourseImp;
import com.implement.LessonImp;
import com.implement.TestImp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.time.Year;
import java.util.List;

@Controller
@RequestMapping("teacher/course-manager")
public class CourseTeacherController {

    @RequestMapping("")
    public String index(Model model, HttpServletRequest request, RedirectAttributes redirectAttributes){
        CourseImp courseImp = new CourseImp();
        HttpSession session = request.getSession();

        if(session.getAttribute("teacherId") != null){
            int teacherId = (int) session.getAttribute("teacherId");
            List<Course> courseList = courseImp.getCourseByTeacher(teacherId);
            model.addAttribute("courseLst", courseList);
            return "/WEB-INF/views/teacher/pages/course/list_all";
        }else {
            model.addAttribute("notification", "Vui lòng đăng nhập trước !!!");
            model.addAttribute("teacherAcc", new Teachers());
            return "/WEB-INF/views/teacher/pages/authentication/login";
        }
    }

    @RequestMapping(value = "detail/{course_id}")
    public String detail(@PathVariable(value = "course_id", required = false) int courseId, Model model){
        CourseImp courseImp = new CourseImp();
        List<Lesson> lessonList = courseImp.getLessonByCourse(courseId);
        model.addAttribute("lessons", lessonList);
        return "/WEB-INF/views/teacher/pages/course/detail";
    }

    @RequestMapping(value = "lesson/{lessonId}", method = RequestMethod.GET)
    public String viewLesson(@PathVariable(value = "lessonId") int lessonId, Model model ){
        LessonImp lessonImp = new LessonImp();

        model.addAttribute("lessonsFound", lessonImp.findById(lessonId));
        model.addAttribute("newTest", new Tests());
        return "/WEB-INF/views/teacher/pages/course/lesson-detail";
    }

    @RequestMapping(value = "lesson/{lessonId}", method = RequestMethod.POST)
    public String postExc(@PathVariable(value = "lessonId") int lessonId,
                          @RequestParam("file") MultipartFile file,HttpServletRequest request, RedirectAttributes redirectAttributes){
        Tests newTest = new Tests();
        TestImp testImp = new TestImp();
        if (testImp.getTestByLesson(lessonId)!= null){
            redirectAttributes.addFlashAttribute("notification","Exercise have been submit!");
        }else{
            try {
                String filename = file.getOriginalFilename(); // Tên file
                byte datafile[] = file.getBytes();

                // 1. Setup tên file vào dữ liệu đối tượng
                newTest.setQuestion(filename); // TODO: nên đổi tên file theo quy tắc (username / email / xyz)
                String realPath = "C:\\SEMII\\SpringLearning\\Elearning\\src\\main\\webapp\\public\\exercise";

                // 2. Upload dữ liệu lên server
                // check file đã tồn tại hay chưa
                File newFile = new File(realPath + "\\" + filename);

                File fileDestination = new File(realPath + File.separator + filename );
                Files.write(fileDestination.toPath(), datafile, StandardOpenOption.CREATE_NEW); // Ghi dữ liệu file

            } catch (IOException e) {
                System.out.println("Lỗi đọc file: " + e.getMessage());
                e.printStackTrace();
            } // Dữ liệu file
        }
        LessonImp lessonImp = new LessonImp();
        String title = request.getParameter("title");
        String times = request.getParameter("times");
        Float mark = Float.valueOf(request.getParameter("mark"));

        newTest.setTitle(title);
        newTest.setTimes(times);
        newTest.setMaxFloat(mark);
        newTest.setLesson(lessonImp.findById(lessonId));
        boolean check = testImp.create(newTest);
        if (check == true)
            redirectAttributes.addFlashAttribute("notification", "Add data successful!!!");
        else
            redirectAttributes.addFlashAttribute("notification", "Add date fail!!");
        String view = "redirect:/teacher/course-manager/lesson/" + lessonId;
        return view;
    }
}
