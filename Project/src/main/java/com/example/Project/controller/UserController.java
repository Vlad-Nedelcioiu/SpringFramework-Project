package com.example.Project.controller;

import com.example.Project.model.User;
import com.example.Project.service.UserService;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class UserController {

    private UserService userService;
    private User currentUser;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(@RequestParam(value = "uname", required = false) String uname,
                              @RequestParam(value = "psw", required = false) String psw, RedirectAttributes redirectAttributes){
        boolean userBoolean =  userService.verifyUser(uname, psw);

        if(uname!= null && userBoolean){
            redirectAttributes.addAttribute("user", uname);
            return "redirect:index";
        }
        return "loginPage";
    }

    @GetMapping("/register")
    public String register(@RequestParam(value = "uname", required = false) String uname,
                                 @RequestParam(value = "psw", required = false) String psw){

        if(uname != null && !userService.verifyUser(uname, psw)){
            userService.createUser(uname,psw);
        }
        return "loginPage";
    }

}
