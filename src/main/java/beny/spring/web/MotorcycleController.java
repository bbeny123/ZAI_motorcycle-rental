package beny.spring.web;

import beny.spring.service.MotorcycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(value = "/motorcycles", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("motorcycles", motorcycleService.getAllMotorcycle());
        return "motorcycles";
    }

}
