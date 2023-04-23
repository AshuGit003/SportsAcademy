package com.SportAcademy.Controller;

import com.SportAcademy.Model.CourseCards;
import com.SportAcademy.Repository.CoachRepository;
import com.SportAcademy.Repository.CourseCardRepository;
import com.SportAcademy.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/courseCards")
public class CourseCardController {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CoachRepository coachRepository;

    @Autowired
    private CourseCardRepository courseCardRepository;


    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("courseCard", new CourseCards());
        model.addAttribute("courses", courseRepository.findAll());
        model.addAttribute("coaches", coachRepository.findAll());
        return "courseCards/create";
    }

    @PostMapping("/save")
    public String saveCourseCard(@ModelAttribute("courseCard") CourseCards courseCard) {
        courseCard.setCourse(courseRepository.getById(courseCard.getCourse().getId()));
        courseCard.setCoach(coachRepository.getById(courseCard.getCoach().getId()));
        courseCardRepository.save(courseCard);
        return "redirect:/courseCards";
    }
}
