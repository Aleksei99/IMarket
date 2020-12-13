package by.smuraha.market.controller;

import by.smuraha.market.*;
import by.smuraha.market.entity.ContactInformation;
import by.smuraha.market.entity.Order;
import by.smuraha.market.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class OrderController {

    private final ContactService contactService;
    private final OrderService orderService;
    private final BasketService basketService;
    private final UserService userService;

    @Autowired
    public OrderController(ContactService contactService, OrderService orderService, BasketService basketService, UserService userService) {
        this.contactService = contactService;
        this.orderService = orderService;
        this.basketService = basketService;
        this.userService = userService;
    }

    @ModelAttribute("contact")
    public ContactInformation getContact() {
        ContactInformation contact = contactService.findUserContact();
        if(contact == null){
            return new ContactInformation();
        }
        return contact;
    }

    @ModelAttribute("order")
    public FullOrderDto getOrder(HttpSession session) {
        FullOrderDto currentOrder = (FullOrderDto) session.getAttribute("currentOrder");
        return currentOrder;
    }

    @GetMapping("/ordering")
    public String getOrderPage(){
        return "ordering";
    }

    @PostMapping("/ordering/confirm")
    public String getSuccessPage(HttpSession session, Model model) {
        FullOrderDto currentOrder = (FullOrderDto)session.getAttribute("currentOrder");
        Order order = orderService.save(currentOrder);
        Long id = order.getId();
        basketService.save(currentOrder,id);
        List<Order> userOrders = orderService.findUserOrders(order.getUser().getId());
        model.addAttribute("trackingOrders",userOrders);
        return "redirect:/user/orders";
    }

    @GetMapping("/user/orders")
    public String getUserOrders(Model model){
        User user = userService.getCurrentUser();
        List<Order> userOrders = orderService.findUserOrders(user.getId());
        model.addAttribute("trackingOrders",userOrders);
        return "tracking";
    }
}
