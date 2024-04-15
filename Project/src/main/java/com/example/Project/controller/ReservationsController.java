package com.example.Project.controller;

import com.example.Project.dao.UserDao;
import com.example.Project.model.User;
import com.example.Project.service.ReservationService;
import com.example.Project.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@Controller
public class ReservationsController {

    private final UserController userController;
    private User currentUser = new User();

    private ReservationService reservationService;

    public ReservationsController(ReservationService reservationService, UserService userService, UserController userController) {
        this.reservationService = reservationService;
        this.userController = userController;
    }

    @PostMapping("/handleForm")
    public String handleForm(Model model, @RequestParam List<String> values,
                             HttpSession session){

        User user = (User) session.getAttribute("user");
        model.addAttribute("uname", user.getName());
        System.out.println(user.getName());
        for (String value : values) {
            System.out.println(value);
            reservationService.createReservation(user.getName(), Integer.parseInt(value));
        }

        //reservationService.showReservationsByIdUser(id_user);
        return "redirect:/index";
    }
}


