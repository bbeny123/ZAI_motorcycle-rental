package beny.spring.web;

import beny.spring.model.MotorcycleData;
import beny.spring.model.UserData;
import beny.spring.service.MotorcycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Beny on 04.06.2017.
 */

@Controller
public class MotorcycleController {

    private final MotorcycleService motorcycleService;

    @Autowired
    public MotorcycleController(MotorcycleService motorcycleService) {
        this.motorcycleService = motorcycleService;
    }

    @RequestMapping("/motorcycle/details/{id}")
    public ModelAndView motorcycleDetails(@PathVariable Long id, Model model) {
        return new ModelAndView("motorcycleshow", "motorcycle", motorcycleService.findById(id));
    }

    @RequestMapping(value = "/motorcycles", method = RequestMethod.GET)
    public String motorcycles(Model model){
        List<MotorcycleData> motorcycles = motorcycleService.getAllMotorcycle();
        model.addAttribute("motorcycles", motorcycles);
        return "motorcycles";
    }

    @RequestMapping(value = "motorcycle/delete/{id}")
    public String delete(@PathVariable Long id) {
        try {
            motorcycleService.removeMotorcycle(id);
            return "redirect:/motorcycles?success";
        } catch(Exception e) {
            return "redirect:/motorcycles?error";
        }
    }

}
