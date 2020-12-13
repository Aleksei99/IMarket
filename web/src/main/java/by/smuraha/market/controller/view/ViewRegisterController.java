package by.smuraha.market.controller.view;

import by.smuraha.market.dto.RoleDto;
import by.smuraha.market.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class ViewRegisterController {

    @ModelAttribute("user")
    public User getUser(){
        return new User();
    }

    @ModelAttribute("roles")
    public RoleDto[] getRoles(){
        return RoleDto.values();
    }

    @GetMapping("/registration")
    public String showTestPage() {
        return "restRegistration";
    }
}
