package org.softuni.mobilele.web;

import org.softuni.mobilele.model.DTO.UserRegistrationDTO;
import org.softuni.mobilele.service.UserService;
import org.softuni.mobilele.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserRegistrationController {
    private UserService userService;

    public UserRegistrationController(UserServiceImpl userServiceImpl) {
        this.userService = userServiceImpl;
    }

    @GetMapping("/register")
    public String register(){
        return "auth-register";
    }

    @PostMapping("register")
    public String register(UserRegistrationDTO userRegistrationDTO){
        userService.registerUser(userRegistrationDTO);
        return "redirect:/";

    }

}
