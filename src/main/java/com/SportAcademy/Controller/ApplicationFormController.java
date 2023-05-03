package com.SportAcademy.Controller;

import com.SportAcademy.Model.ApplicationForm;
import com.SportAcademy.Model.CoachDetails;
import com.SportAcademy.Model.CourseCards;
import com.SportAcademy.Model.CourseDetails;
import com.SportAcademy.Service.ApplicationFormService;
import com.SportAcademy.Service.CoachService;
import com.SportAcademy.Service.CourseCardService;
import com.SportAcademy.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class ApplicationFormController {

    @Autowired
    private ApplicationFormService applicationFormService;

    @Autowired
    private CourseCardService courseCardService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private CoachService coachService;

    @GetMapping("/courseCards/{courseCardId}")
    public String applicationForm(@PathVariable(value = "courseCardId") long courseCardId, Model model){
        CourseCards cards = courseCardService.getCourseCardsById(courseCardId);
        CourseDetails course = courseService.getCourseById(cards.getCourse().getId());
        CoachDetails coach = coachService.getCoachById(cards.getCoach().getId());

        model.addAttribute("applicationForm",new ApplicationForm());
        model.addAttribute("courseCard",cards);
        model.addAttribute("course",course);
        model.addAttribute("coach",coach);

        return  "application_form";
    }

    @PostMapping("/saveApplicationForm")
    public String saveCourseCard(@ModelAttribute("applicationForm") ApplicationForm applicationForm, HttpSession session){
        //save student to database
        ApplicationForm formObj = applicationFormService.createApplicationForm(applicationForm);
        if(formObj != null){
            session.setAttribute("msg","Form Saved");
        }else {
            session.setAttribute("msg","Something Went Wrong");
        }
        return "application_form";
    }
}
