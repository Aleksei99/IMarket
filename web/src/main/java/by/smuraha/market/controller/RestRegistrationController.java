package by.smuraha.market.controller;

import by.smuraha.market.UserService;
import by.smuraha.market.entity.Role;
import by.smuraha.market.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RestRegistrationController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/restRegister")
    public User saveUser(@RequestBody @Valid User user, Errors errors) {
        if(errors.hasErrors()){
            return userService.setErrorJSONUser(errors);
        }
        userService.save(user);
        return new User();
    }

}
