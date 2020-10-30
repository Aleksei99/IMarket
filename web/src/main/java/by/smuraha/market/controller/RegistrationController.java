package by.smuraha.market.controller;

import by.smuraha.market.UserService;
import by.smuraha.market.dto.RoleDto;
import by.smuraha.market.entity.Role;
import by.smuraha.market.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String getRegisterPage(){
        return "registration";
    }

    @ModelAttribute("user")
    public User getUser(){
        return new User();
    }

    @ModelAttribute("roles")
    public RoleDto[] getRoles(){
        return RoleDto.values();
    }

    @PostMapping
    public String saveUser(@Valid User user, Errors errors){
        if(errors.hasErrors()){
            return "registration";
        }
        userService.save(user);
        return "redirect:/login";
    }
}
