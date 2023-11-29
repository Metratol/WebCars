package com.example.SpringCars.web.controllers;

import com.example.SpringCars.modelsDto.UserDto;
import com.example.SpringCars.services.UserRoleService;
import com.example.SpringCars.services.UserService;
import com.example.SpringCars.web.view.ModelView;
import com.example.SpringCars.web.view.OfferView;
import com.example.SpringCars.web.view.UserCreation;
import com.example.SpringCars.web.view.UserView;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
public class UserController {
    UserService userService;
    UserRoleService userRoleService;

    public UserController(UserService userService, UserRoleService userRoleService) {
        this.userService = userService;
        this.userRoleService = userRoleService;
    }
    @GetMapping("/users")
    public String getAllUsers(Model model){
        List<UserView> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "all-users";
    }
    @GetMapping("/{username}/offers")
    public String getAllUserOffers(@PathVariable String username, Model model){
        List<OfferView> offers = userService.allUserOffers(username);

        model.addAttribute("All user offers", offers);
        return "user-page";
    }
    @GetMapping("/list")
    public String userList(Model model){
        List<UserView> users = userRoleService.allUserUser();

        model.addAttribute("All brand models", users);
        return "all-brand-models";
    }
    @PostMapping("/register")
    public @ResponseBody String regNewUser(@RequestBody UserCreation userInput) {
        userService.register(userInput);
        return "user-page";
    }

        @PutMapping("/delete")
        public String unactiveUser (@RequestParam String id ){
            userService.unactiveUser(id);
            return "user-page";
        }
}