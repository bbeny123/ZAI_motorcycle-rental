package beny.spring.web;

import beny.spring.model.MotorcycleData;
import beny.spring.service.MotorcycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(value = "/motorcycles", method = RequestMethod.GET)
    public String motorcycles(Model model){
        List<MotorcycleData> motorcycles = motorcycleService.getAllMotorcycle();
        model.addAttribute("motorcycles", motorcycles);
        return "motorcycles";
    }


}
