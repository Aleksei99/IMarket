package by.smuraha.market.controller.view;

import by.smuraha.market.BasketService;
import by.smuraha.market.ContactService;
import by.smuraha.market.OrderService;
import by.smuraha.market.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;

@Controller
public class ViewAdminController {
    private final OrderService orderService;
    private final ContactService contactService;
    private final BasketService basketService;

    @Autowired
    public ViewAdminController(OrderService orderService, ContactService contactService, BasketService basketService) {
        this.orderService = orderService;
        this.contactService = contactService;
        this.basketService = basketService;
    }

    @GetMapping("/admin")
    public String getPage(){
        return "admin";
    }

    @GetMapping("/admin/orders")
    public String allOrders( Model model){
        List<Order> orders = orderService.findAll();
        model.addAttribute("orders",orders);
        return "orders";
    }

    @GetMapping("/admin/orders/{time}")
    public String ordersByTime(@PathVariable("time") int hours,Model model){
        List<Order> orders = orderService.findOrders(hours);
        model.addAttribute("orders",orders);
        return "orders";
    }

    @PostMapping("/admin/orders/time")
    public String orders(@RequestParam("hours") int hours){
        return "redirect:/admin/orders/"+hours;
    }

    @GetMapping("/order/{id}")
    public String showDetails(@PathVariable("id") Long orderId, Model model) {
        Order order =  orderService.findById(orderId);
        List<Basket> baskets = basketService.findAllByOrderID(orderId);
        User user = order.getUser();
        Set<Product> products = order.getProducts();
        ContactInformation contact = contactService.findByUser(user);
        model.addAttribute("baskets",baskets);
        model.addAttribute("products",products);
        model.addAttribute("contact",contact);
        model.addAttribute("order",order);
        return "detailOrder";
    }

    @PostMapping("/admin/accept")
    public String orderAccept(@RequestParam("id") Long id){
        Order order = orderService.findById(id);
        order.setStatement(Statement.ACCEPTED);
        orderService.save(order);
        return "redirect:/order/"+id;
    }

    @PostMapping("/admin/inWay")
    public String orderInWay(@RequestParam("id") Long id){
        Order order = orderService.findById(id);
        order.setStatement(Statement.IN_WAY);
        orderService.save(order);
        return "redirect:/order/"+id;
    }
    @PostMapping("/admin/delivered")
    public String orderDelivered(@RequestParam("id") Long id){
        Order order = orderService.findById(id);
        order.setStatement(Statement.DELIVERED);
        orderService.save(order);
        return "redirect:/order/"+id;
    }
}
