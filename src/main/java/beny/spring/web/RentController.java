package beny.spring.web;

import beny.spring.model.RentData;
import beny.spring.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * Created by Beny on 04.06.2017.
 */

@Controller
public class RentController {

    private final RentService rentService;

    @Autowired
    public RentController(RentService rentService) {
        this.rentService = rentService;
    }

    @PreAuthorize("@currentUserServiceImpl.canAccessUser(principal, #id)")
    @RequestMapping("/user/{id}")
    public ModelAndView getUserRents(@PathVariable Long id, Model model) {
        return new ModelAndView("userRents", "rents", rentService.findById(id));
    }

    @RequestMapping(value = "/rents/all", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("rents", rentService.getAllRents());
        return "rents";
    }

    @RequestMapping("rent/{id}")
    public String showProduct(@PathVariable Long id, Model model){
        model.addAttribute("rent", rentService.findById(id));
        return "rentshow";
    }

    @RequestMapping("rent/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        model.addAttribute("rent", rentService.findById(id));
        return "rentform";
    }

    @RequestMapping("rent/new")
    public String newProduct(Model model){
        model.addAttribute("rent", new RentData());
        return "rentform";
    }

    @RequestMapping(value = "rent", method = RequestMethod.POST)
    public String saveProduct(RentData rent){
        rentService.saveRent(rent);
        return "redirect:/rent/" + rent.getId();
    }

    @RequestMapping("rent/delete/{id}")
    public String delete(@PathVariable Long id){
        rentService.deleteRent(id);
        return "redirect:/rents";
    }

}
