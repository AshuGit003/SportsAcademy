package com.SportAcademy.Controller;

import com.SportAcademy.Model.ApplicationForm;
import com.SportAcademy.Model.ContactUs;
import com.SportAcademy.Service.ContactUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class ContactUsController {

    @Autowired
    private ContactUsService contactUsService;

    @PostMapping("/saveContactUs")
    public String saveContactUs(@ModelAttribute("contactUs") ContactUs contactUs, HttpSession session){
        //save student to database
        ContactUs contactObj = contactUsService.createContactUs(contactUs);
        if(contactObj != null){
            session.setAttribute("msg","Your Feedback is saved");
        }else {
            session.setAttribute("msg","Something Went Wrong");
        }
        return "contact";
    }
}
