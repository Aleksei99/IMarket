package by.smuraha.market.controller.view;

import by.smuraha.market.ContactService;
import by.smuraha.market.UserService;
import by.smuraha.market.entity.ContactInformation;
import by.smuraha.market.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ViewSellerController {

    private final UserService userService;
    private final ContactService contactService;

    @Autowired
    public ViewSellerController(UserService userService, ContactService contactService) {
        this.userService = userService;
        this.contactService = contactService;
    }

    @GetMapping("/seller")
    public String getPage(){
        return "addProduct";
    }

    @GetMapping("/seller/{id}")
    public String getSellerPage(@PathVariable("id") Long id, Model model){
        User user = userService.findUserById(id);
        ContactInformation contact = contactService.findByUser(user);
        model.addAttribute("contact", contact);
        return "seller";
    }
}
