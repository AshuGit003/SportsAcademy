package com.SportAcademy.Controller;

import com.SportAcademy.Model.*;
import com.SportAcademy.Repository.CoachRepository;
import com.SportAcademy.Repository.CourseRepository;
import com.SportAcademy.Repository.UserRepository;
import com.SportAcademy.Service.ApplicationFormService;
import com.SportAcademy.Service.CoachService;
import com.SportAcademy.Service.CourseCardService;
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
    private CourseRepository courseRepository;

    @Autowired
    private CoachRepository coachRepository;

    @Autowired
    private CourseService courseService;

    @Autowired
    private CoachService coachService;

    @Autowired
    private CourseCardService courseCardService;

    @Autowired
    private ApplicationFormService applicationFormService;

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


//    course api
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
        return "user/update_course";
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

//coach api
    @GetMapping("/coach")
    public String coach(Model model){
        model.addAttribute("listCoach", coachService.getAllCoaches());
        return "user/coach";
    }

    @GetMapping("/showNewCoachForm")
    public String showNewCoachForm(Model model){
        //create model attribute to bind form data
        CoachDetails coach = new CoachDetails();
        model.addAttribute("coach", coach);
        return "user/add_coach";
    }

    @GetMapping("/coachUpdateForm/{coachId}")
    public  String coachUpdateForm(@PathVariable(value = "coachId") long coachId, Model model){

        //get student from the service
        CoachDetails coach = coachService.getCoachById(coachId);

        //set student as a model attribute to pre-populate the form
        model.addAttribute("coach", coach);
        return "user/update_coach";
    }

    @GetMapping("/deleteCoach/{coachId}")
    public String deleteCoach(@PathVariable(value = "coachId") long coachId){

        //call delete student method
        this.coachService.deleteCoach(coachId);
        return "redirect:/user/coach";
    }

    @PostMapping("/saveCoach")
    public String saveCoach(@ModelAttribute("coach") CoachDetails coach, HttpSession session){
        //save student to database
        CoachDetails coachObj = coachService.createCoach(coach);
        if(coachObj != null){
            session.setAttribute("msg","Coach Saved");
        }else {
            session.setAttribute("msg","Something Went Wrong");
        }
        return "user/add_coach";
    }

    //Course Cards api
    @GetMapping("/courseCards")
    public String courseCards(Model model) {
        model.addAttribute("listCourseCards", courseCardService.getAllCourseCards());
        return "user/courseCards";
    }

    @GetMapping("/showNewCourseCardForm")
    public String showNewCourseCardForm(Model model){
        //create model attribute to bind form data
        model.addAttribute("courseCard", new CourseCards());
        model.addAttribute("courses", courseRepository.findAll());
        model.addAttribute("coaches", coachRepository.findAll());
        return "user/add_courseCard";
    }

    @GetMapping("/courseCardUpdateForm/{courseCardId}")
    public  String courseCardUpdateForm(@PathVariable(value = "courseCardId") long courseCardId, Model model){

        //get student from the service
        CourseCards cards = courseCardService.getCourseCardsById(courseCardId);

        //set student as a model attribute to pre-populate the form
        model.addAttribute("courseCard", cards);
        model.addAttribute("courses", courseRepository.findAll());
        model.addAttribute("coaches", coachRepository.findAll());
        return "user/update_courseCard";
    }

    @GetMapping("/deleteCourseCard/{courseCardId}")
    public String deleteCourseCard(@PathVariable(value = "courseCardId") long courseCardId){

        //call delete student method
        this.courseCardService.deleteCourseCards(courseCardId);
        return "redirect:/user/courseCards";
    }

    @PostMapping("/saveCourseCard")
    public String saveCourseCard(@ModelAttribute("courseCard") CourseCards courseCards, HttpSession session){
        //save student to database
        CourseCards cardObj = courseCardService.createCourseCards(courseCards);
        if(cardObj != null){
            session.setAttribute("msg","Card Saved");
        }else {
            session.setAttribute("msg","Something Went Wrong");
        }
        return "user/add_courseCard";
    }

    //application api
    @GetMapping("/applicationFormList")
    public String application(Model model) {
        model.addAttribute("listApplicationForm", applicationFormService.getAllApplicationForm());
        return "user/application_list";
    }
}


