package com.SportAcademy.Controller;

import com.SportAcademy.Model.UserDetails;
import com.SportAcademy.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    public UserService userService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/signin")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/createUser")
    public String createuser(@ModelAttribute UserDetails user, HttpSession session) {
        //System.out.println(user);

        boolean flag = userService.checkEmail(user.getEmail());

        if(flag){
            session.setAttribute("msg","Email Id already exist");
        }else {
            UserDetails userDetails = userService.createUser(user);
            if (userDetails != null) {
                session.setAttribute("msg","Register Successfully");
            } else {
                session.setAttribute("msg","Something Went Wrong");
            }
        }
        return "redirect:/register";
    }
}
