package by.smuraha.market.controller.view;

import by.smuraha.market.ContactService;
import by.smuraha.market.entity.ContactInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewContactController {
    private final ContactService contactService;

    @Autowired
    public ViewContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/info")
    public String getInfoPage(Model model) {
        ContactInformation userContact = contactService.findUserContact();
        model.addAttribute("contact", userContact);
        return "contactInformation";
    }
}
