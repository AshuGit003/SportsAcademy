package com.SportAcademy.Controller;

import com.SportAcademy.Model.CourseDetails;
import com.SportAcademy.Model.UserDetails;
import com.SportAcademy.Repository.UserRepository;
import com.SportAcademy.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private CourseService courseService;

    @ModelAttribute
    private void userDetails(Model m, Principal p)
    {
        String email=p.getName();
        UserDetails user = userRepo.findByEmail(email);
        m.addAttribute("user",user);
    }

    @GetMapping("")
        public String home(){
        return "user/Home";
    }

//    @GetMapping("/")
//    public String listCourse(Model model){
//
//
//        return "user/Home";
//    }

    @GetMapping("/course")
    public String course(Model model){
        model.addAttribute("listCourse", courseService.getAllCourses() );
        return "user/course";
    }

    @GetMapping("/showNewCourseForm")
    public String showNewCourseForm(Model model){
        //create model attribute to bind form data
        CourseDetails course = new CourseDetails();
        model.addAttribute("course", course);
        return "user/add_course";
    }

    @GetMapping("/courseUpdateForm/{courseId}")
    public  String courseUpdateForm(@PathVariable(value = "courseId") long courseId, Model model){

        //get student from the service
        CourseDetails course = courseService.getCourseById(courseId);

        //set student as a model attribute to pre-populate the form
        model.addAttribute("course", course);
        return "user/course";
    }

    @GetMapping("/deleteCourse/{courseId}")
    public String deleteCourse(@PathVariable(value = "courseId") long courseId){

        //call delete student method
        this.courseService.deleteCourse(courseId);
        return "redirect:/user/course";
    }

    @PostMapping("/saveCourse")
    public String saveCourse(@ModelAttribute("course") CourseDetails course, HttpSession session){
        //save student to database
       CourseDetails courseObj = courseService.createCourse(course);
       if(courseObj != null){
           session.setAttribute("msg","Course Saved");
       }else {
           session.setAttribute("msg","Something Went Wrong");
       }
        return "user/add_course";
    }

    @GetMapping("/coach")
    public String coach(){
        return "user/coach";
    }




}
