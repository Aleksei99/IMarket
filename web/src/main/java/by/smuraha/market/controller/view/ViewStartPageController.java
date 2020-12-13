package by.smuraha.market.controller.view;

import by.smuraha.market.dto.CartDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class ViewStartPageController {
    @GetMapping("/")
    public String showPage(HttpSession session) {
        if(session.getAttribute("currentCart")==null){
            session.setAttribute("currentCart",new CartDto());
        }
        return "startPage";
    }
}
