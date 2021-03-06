package beny.spring.web;

import beny.spring.model.MotorcycleData;
import beny.spring.service.MotorcycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
    public String motorcycleDetails(@PathVariable Long id, Model model) {
        MotorcycleData motorcycle = motorcycleService.findById(id);
        if(motorcycle != null) {
            model.addAttribute("motorcycle", motorcycle);
            return "motorcycleshow";
        } else {
            return "redirect:/motorcycles?error";
        }
    }

    @RequestMapping(value = "/motorcycles", method = RequestMethod.GET)
    public String getMotorcycles(Model model){
        List motorcycles = motorcycleService.getAllAvailableMotorcycles();
        model.addAttribute("motorcycles", motorcycles);
        return "motorcycles";
    }

    @RequestMapping(value = "/motorcycles/all", method = RequestMethod.GET)
    public String getAllMotorcycles(Model model){
        List motorcycles = motorcycleService.getAllMotorcycles();
        model.addAttribute("motorcycles", motorcycles);
        model.addAttribute("all", Boolean.TRUE);
        return "motorcycles";
    }

    @RequestMapping(value = "motorcycles", method = RequestMethod.POST)
    public String saveMotorcycle(MotorcycleData motorcycle, @RequestParam("file") MultipartFile file) {
        try {
            if(!file.isEmpty())
                motorcycle.setPhoto(file.getBytes());
            motorcycleService.saveMotorcycle(motorcycle);
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/motorcycles?error";
        }
        return "redirect:/motorcycles?success";
    }

    @RequestMapping(value = "motorcycle/delete", method = RequestMethod.DELETE)
    public String deleteMotorcycle(Long id) {
        try {
            motorcycleService.removeMotorcycle(id);
            return "redirect:/motorcycles?success";
        } catch(Exception e) {
            return "redirect:/motorcycles?error";
        }
    }

    @RequestMapping(value = "motorcycle/edit/{id}")
    public String editMotorcycle(@PathVariable Long id, Model model) {
        MotorcycleData motorcycle = motorcycleService.findById(id);
        if(motorcycle != null) {
            model.addAttribute("motorcycle", motorcycle);
            return "motorcycleform";
        } else {
            return "redirect:/motorcycle/new";
        }
    }

    @RequestMapping(value = "motorcycle/new")
    public String newMotorcycle(Model model) {
        model.addAttribute("motorcycle", new MotorcycleData());
        return "motorcycleform";
    }

}
