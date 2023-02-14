package com.example.demo.Controller;

import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }
    @GetMapping("/signup")
    public ModelAndView signup(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("signup.html");
        mv.addObject("title","Signup");
        return mv;
    }
    @PostMapping("/signup/userAdd")
    public String userAdd(@ModelAttribute User user){
//        User user = new User(5,fullName,email,username,password,"user");
        if(userService.addUser(user)){
            return "redirect:/signup";
        }
        return "Failed";
    }
}
