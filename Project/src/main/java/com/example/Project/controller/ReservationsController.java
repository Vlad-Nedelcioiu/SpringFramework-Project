package com.example.Project.controller;

import com.example.Project.model.User;
import com.example.Project.service.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ReservationsController {

    private ReservationService reservationService;

    public ReservationsController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/handleForm")
    public String handleForm(@RequestParam List<String> values){

        int id_user = User.getId();
        for (String v : values){
            reservationService.createReservation(id_user, Integer.parseInt(v));
        }

        System.out.println("Rezervari: ");
        reservationService.showReservationsByIdUser(id_user);
        return "redirect:/flights";
    }

}

