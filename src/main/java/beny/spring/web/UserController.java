package beny.spring.web;

import beny.spring.model.UserData;
import beny.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @RequestMapping(value = "register")
    public ModelAndView register(@RequestParam Optional<String> error, Model model) {
        model.addAttribute("user", new UserData());
        return new ModelAndView("registerform", "error", error);
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ModelAndView saveUser(UserData user, BindingResult result) throws Exception {
        if(userService.getUserByEmail(user.getEmail()).isPresent()) {
            result.rejectValue("email", "error");
            ModelAndView mav = new ModelAndView("registerform");
            mav.addObject("user", user);
            return mav;
        }
        else{
            try {
                user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
                userService.save(user);
                return new ModelAndView("login");
            } catch(Exception e) {
                result.rejectValue("email", "error");
                ModelAndView mav = new ModelAndView("registerform");
                mav.addObject("user", user);
                return mav;
            }
        }
    }

}
