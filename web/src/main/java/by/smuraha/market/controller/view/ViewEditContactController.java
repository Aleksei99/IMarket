package by.smuraha.market.controller.view;

import by.smuraha.market.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewEditContactController {
    private final ContactService contactService;

    @Autowired
    public ViewEditContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/editDetails")
    public String getPage(){
        return "editContactInformation";
    }
}
