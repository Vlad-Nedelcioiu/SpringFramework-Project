package com.example.Project.controller;

import com.example.Project.model.User;
import com.example.Project.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(@RequestParam(value = "uname", required = false) String uname,
                        @RequestParam(value = "psw", required = false) String psw,
                        RedirectAttributes redirectAttributes,
                        HttpSession session){

        System.out.println("Username: " + uname); // debug
        System.out.println("Password: " + psw); // debug
        boolean userBoolean =  userService.verifyUser(uname, psw);

        if(uname!= null && userBoolean){
            User user = new User();
            user.setName(uname);
            session.setAttribute("user", user);
            redirectAttributes.addAttribute("user", uname);
            System.out.println("succes"); // debug
            return "redirect:/index";
        }
        System.out.println("fail");
        return "loginPage";
    }

    @GetMapping("/register")
    public String register(@RequestParam(value = "uname", required = false) String uname,
                                 @RequestParam(value = "psw", required = false) String psw){

        if(uname != null && !userService.verifyUser(uname, psw)){
            userService.createUser(uname,psw);
        }
        return "register";
    }

}
