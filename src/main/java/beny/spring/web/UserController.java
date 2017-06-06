package beny.spring.web;

import beny.spring.model.CurrentUser;
import beny.spring.model.UserData;
import beny.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping(value = "/register")
    public String register(Model model) {
        model.addAttribute("user", new UserData());
        return "registrationform";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ModelAndView registerUser(UserData user, BindingResult result) {
        ModelAndView model = new ModelAndView("registrationform");
        if(userService.getUserByEmail(user.getEmail()).isPresent()) {
            result.rejectValue("email", "error");
            model.addObject("user", user);
            return model;
        }
        else{
            String userPassword = user.getPassword();
            user.setAdmin(false);
            try {
                user.setPassword(new BCryptPasswordEncoder().encode(userPassword));
                userService.save(user);
                return new ModelAndView("redirect:/login");
            } catch(Exception e) {
                user.setPassword(userPassword);
                result.rejectValue("email", "error");
                model.addObject("user", user);
                return model;
            }
        }
    }

    @PreAuthorize("@currentUserServiceImpl.canAccessUser(principal, #id)")
    @RequestMapping(value = "/user/{id}")
    public String showUser(@PathVariable Long id, Model model) {
        UserData user = userService.getUserById(id);
        if(user != null) {
            model.addAttribute("user", user);
            return "usershow";
        } else {
            return "redirect:/";
        }
    }

    @PreAuthorize("@currentUserServiceImpl.canAccessUser(principal, #id)")
    @RequestMapping(value = "user/edit/{id}", method = RequestMethod.PUT)
    public ModelAndView saveUser(@PathVariable Long id, UserData user, String oldPassword, String email, BindingResult result) {

        CurrentUser currentUser = new CurrentUserControllerAdvice().getCurrentUser(SecurityContextHolder.getContext().getAuthentication());

        if(!currentUser.getRole().equals("ADMIN")) {
            if(!currentUser.getId().equals(id) || !currentUser.getId().equals(user.getId()))
                return new ModelAndView("redirect:/users?error");
            user.setAdmin(false);
        }

        if(user.getPassword().length() == 0)
            user.setPassword(oldPassword);
        else
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

        try {
            userService.save(user);
            if(!currentUser.getRole().equals("ADMIN"))
                return new ModelAndView("redirect:/user/{id}");
            return new ModelAndView("redirect:/users?success");
        } catch(Exception e) {
            result.rejectValue("email", "error");
            ModelAndView model = new ModelAndView("userform");
            model.addObject("user", user);
            return model;
        }
    }

    @PreAuthorize("@currentUserServiceImpl.canAccessUser(principal, #id)")
    @RequestMapping(value = "/user/edit/{id}")
    public String editUser(@PathVariable Long id, Model model) {
        UserData userData = userService.getUserById(id);
        if(userData != null) {
            model.addAttribute("user", userData);
            return "userform";
        } else {
            return "redirect:/register";
        }
    }

    @RequestMapping(value = "user/delete", method = RequestMethod.DELETE)
    public String deleteUser(Long id) {
        try {
            userService.delete(id);
            return "redirect:/users?success";
        } catch(Exception e) {
            return "redirect:/users?error";
        }
    }

}
