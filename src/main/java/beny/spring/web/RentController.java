package beny.spring.web;

import beny.spring.model.CurrentUser;
import beny.spring.model.RentData;
import beny.spring.service.MotorcycleService;
import beny.spring.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Beny on 04.06.2017.
 */

@Controller
public class RentController {

    private final RentService rentService;
    private final MotorcycleService motorcycleService;

    @Autowired
    public RentController(RentService rentService, MotorcycleService motorcycleService) {
        this.rentService = rentService;
        this.motorcycleService = motorcycleService;
    }

    @PreAuthorize("@currentUserServiceImpl.canAccessUser(principal, #id)")
    @RequestMapping("/user/{id}/rents")
    public String getActiveUserRents(@PathVariable Long id, Model model) {
        model.addAttribute("rents",rentService.getActiveUserRents(id));
        return "userRents";
    }

    @PreAuthorize("@currentUserServiceImpl.canAccessUser(principal, #id)")
    @RequestMapping("/user/{id}/rents/all")
    public String getAllUserRents(@PathVariable Long id, Model model) {
        model.addAttribute("rents",rentService.getAllUserRents(id));
        model.addAttribute("all", Boolean.TRUE);
        return "userRents";
    }

    @RequestMapping(value = "/rents", method = RequestMethod.GET)
    public String getActiveRents(Model model){
        model.addAttribute("rents", rentService.getActiveRents());
        return "rents";
    }

    @RequestMapping(value = "/rents/all", method = RequestMethod.GET)
    public String getAllRents(Model model){
        model.addAttribute("rents", rentService.getAllRents());
        model.addAttribute("all", Boolean.TRUE);
        return "rents";
    }

    @RequestMapping(value = "motorcycle/rent/{mtoId}", method = RequestMethod.POST)
    public String rentMotorcycle(@PathVariable Long mtoId) {
        if(!motorcycleService.findById(mtoId).isAvailable())
            return "redirect:/motorcycles?error";

        CurrentUserControllerAdvice a = new CurrentUserControllerAdvice();
        CurrentUser currentUser = a.getCurrentUser(SecurityContextHolder.getContext().getAuthentication());
        Long usrId = currentUser.getId();
        try {
            rentService.newRent(currentUser.getId(), mtoId);
            return "redirect:/user/" + usrId + "/rents";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/motorcycles?error";
        }
    }

    @RequestMapping(value = "rent/finish/{id}", method = RequestMethod.PUT)
    public String finishRent(@PathVariable Long id) {
        if(!rentService.findById(id).isActive())
            return "redirect:/rents/all?error";

        try {
            rentService.finishRent(id);
            return "redirect:/rents/all?success";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/rents/all?error";
        }
    }

    @RequestMapping(value = "rent/cancel/{id}", method = RequestMethod.PUT)
    public String cancelRent(@PathVariable Long id) {
        if(!rentService.findById(id).isActive())
            return "redirect:/rents/all?error";

        try {
            rentService.cancelRent(id);
            return "redirect:/rents/all?success";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/rents/all?error";
        }
    }

}
