package com.example.Project.controller;

import com.example.Project.model.Trip;
import com.example.Project.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class TripController {

    @Autowired
    private TripService tripService;

    List<Trip> tripList;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping("/index")
    public String index(Model model, String city, String checkIn, String checkOut,
                        @ModelAttribute("user") String user, RedirectAttributes redirectAttributes){
        if(city != null && !city.isEmpty()){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy");
            String checkInDate = checkIn.substring(checkIn.indexOf(" ")).trim();
            String checkOutDate = checkOut.substring(checkOut.indexOf(" ")).trim();

            System.out.println(checkInDate);
            System.out.println(checkOutDate);

            tripList = tripService.showTrips(city,
                    Date.valueOf(LocalDate.parse(checkInDate, formatter)),
                    Date.valueOf(LocalDate.parse(checkOutDate, formatter)));

            System.out.println(tripList);

            model.addAttribute(user);
            System.out.println(user);

            redirectAttributes.addAttribute("user", user);
            return "redirect:flights";
        }
        return "index";
    }

    @GetMapping("/flights")
    public String showTrips(Model model, @RequestParam Map<String,String> allParams){
        List<Integer> tripIds = tripService.getAllFlightIds();
        model.addAttribute("flightsIds", tripList);
        return "flights";
    }
}
