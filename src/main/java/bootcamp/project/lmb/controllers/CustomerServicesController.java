/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.project.lmb.controllers;

import bootcamp.project.lmb.dao.HotelDao;
import bootcamp.project.lmb.dao.RatingDao;
import bootcamp.project.lmb.dao.RoomUnavailabilityDao;
import bootcamp.project.lmb.model.Hotel;
import bootcamp.project.lmb.model.Rating;
import bootcamp.project.lmb.model.RoomUnavailability;
import bootcamp.project.lmb.model.User;
import java.util.Date;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author minas
 */
@Controller
@SessionAttributes({"loggedUser"})
@RequestMapping(value = "/user")
public class CustomerServicesController {

    @Autowired
    RoomUnavailabilityDao rur;

    @Autowired
    HotelDao hd;

    @Autowired
    RatingDao rd;

    @GetMapping("/customer_services")
    public String getCustomerServices(ModelMap model, @SessionAttribute("loggedUser") User user, HttpSession session) {

        User updateUser = new User();
        RoomUnavailability availableRatings = rur.availableRatings(user.getId());
        if(availableRatings!=null){
                    session.setAttribute("availableRatings", availableRatings);
                    session.setAttribute("hotelRating", hd.getHotelById(rur.availableRatings(user.getId()).getHotelid().getId()));
        }
        else{
            session.removeAttribute("availableRatings");
        }
        
        model.addAttribute("updateUser", updateUser);
        return "customer_services";
    }

    @PostMapping("/submitRating")
    public String submitRatingofUser(ModelMap model,
            @SessionAttribute("loggedUser") User user,
            @SessionAttribute("hotelRating") Hotel hotel,
            @RequestParam(value = "GeneralAssessment") int GeneralAssessment,
            @RequestParam(value = "Cleanliness") int Cleanliness,
            @RequestParam(value = "Staffing") int Staffing,
            @RequestParam(value = "HotelFacilities") int HotelFacilities,
            @RequestParam(value = "RoomEquipment") int RoomEquipment,
            @RequestParam(value = "Comments") String Comments
    ) {

        float rating = (GeneralAssessment + Cleanliness + Staffing + HotelFacilities + RoomEquipment) / 5;

        rd.insertRating(user.getId(), hotel.getId(), rating, Comments);

        return "redirect:/user/customer_services";
    }
}
