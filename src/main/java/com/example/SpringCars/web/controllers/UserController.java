package com.example.SpringCars.web.controllers;

import com.example.SpringCars.models.User;
import com.example.SpringCars.models.enums.CategoryEnum;
import com.example.SpringCars.modelsDto.UserDto;
import com.example.SpringCars.services.UserRoleService;
import com.example.SpringCars.services.UserService;
import com.example.SpringCars.web.view.ModelView;
import com.example.SpringCars.web.view.OfferView;
import com.example.SpringCars.web.view.UserCreation;
import com.example.SpringCars.web.view.UserView;
import jakarta.validation.Valid;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StopWatch;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

@Controller
public class UserController {
    private static final Logger LOG = LogManager.getLogger(Controller.class);
    UserService userService;
    UserRoleService userRoleService;

    public UserController(UserService userService, UserRoleService userRoleService) {
        this.userService = userService;
        this.userRoleService = userRoleService;
    }
    @GetMapping("/users")
    public String getAllUsers(Model model,Principal principal){
        LOG.log(Level.INFO,"Admin " + principal.getName() + "check all users");
        List<UserView> users = userRoleService.allUserUser();
        model.addAttribute("users", users);
        return "all-users";
    }
    @GetMapping("/users/{username}/detailinfo")
    public String userInfo(@PathVariable String username, Model model,Principal principal) {
        LOG.log(Level.INFO,"Admin " + principal.getName() + "check user info");
        userService.findUserByUsername(username);
        model.addAttribute("user",userService.findUserByUsername(username).get());
        model.addAttribute("categories", CategoryEnum.values());
        return "user-card";
    }

    @GetMapping("users/usersdelete/{username}")
    public String unactiveUser (@PathVariable("username") String username){
        userService.changeUserStatus(username);
        userService.findUserByUsername(username).get().getUsername();
        return "redirect:/users/"+userService.findUserByUsername(username).get().getUsername() +"/detailinfo";
    }
    @GetMapping("/registration")
    public String regisration(){
        return "register-page";
    }
    @ModelAttribute("userModel")
    public UserCreation initCompany() {
        return new UserCreation();
    }
    @PostMapping("/registration")
    public String registration(@Valid UserCreation userModel, BindingResult bindingResult, RedirectAttributes redirectAttributes,Principal principal){
        LOG.log(Level.INFO,"user register the profile");
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("userModel",userModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userModel",bindingResult);
            return "redirect:/registration";
        }
        UserView user = userService.register(userModel);
        return "redirect:/login";
    }
    @GetMapping("/login")
    public String login() {
        return "login-page";
    }

    @PostMapping("/login")
    public String onFailedLogin(
            @ModelAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY) String username,
            RedirectAttributes redirectAttributes) {

        redirectAttributes.addFlashAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY, username);
        redirectAttributes.addFlashAttribute("badCredentials", true);

        return "redirect:/";
    }

    @GetMapping("/profile")
    public String profile(Principal principal, Model model) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        LOG.log(Level.INFO,"User " + principal.getName() + "enter the profile");
        String username = principal.getName();
        User user = userService.getUser(username);
        UserView userProfileView = new UserView(
                username,
                user.getFirstName(),
                user.getLastName()

        );
        model.addAttribute("offers",userService.allUserOffers(username));
        model.addAttribute("user", userProfileView);
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());
        return "user-page";
    }
}

