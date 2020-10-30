package by.smuraha.market.controller;

import by.smuraha.market.UserService;
import by.smuraha.market.entity.Role;
import by.smuraha.market.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class RestRegistrationController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/registration/rest")
    public User getRegisterPage() {
        return new User("name", "surname", "username", "Qwerty1234", Role.USER);
    }

    @GetMapping(value = "/test1")
    public User getTest() {
        return new User("name123", "surname", "username", "Qwerty1234", Role.USER);
    }

    @PostMapping(value = "/restRegister")
    public User saveUser(@RequestBody @Valid User user) {
        User saved = userService.save(user);
        return saved;
    }

    @PostMapping(value = "/test")
    public User some(@RequestBody User user) {
        return user;
    }
}
