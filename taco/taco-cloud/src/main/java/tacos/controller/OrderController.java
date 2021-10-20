package tacos.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import tacos.entity.Order;
import tacos.entity.User;
import tacos.repository.OrderRepository;
import tacos.repository.UserRepository;

import javax.validation.Valid;
import java.security.Principal;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
/*@ConfigurationProperties(prefix = "taco.orders")*/
public class OrderController {

    private int pageSize = 20;

    private OrderRepository orderRepo;

    @Autowired
    public OrderController(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    @GetMapping
    public String orderForm(Model model) {
        model.addAttribute("order", new Order());
        return "orderForm";
    }

/*    @GetMapping
    public String orderFromUser(@AuthenticationPrincipal User user, Model model) {
        Pageable pageable = PageRequest.of(0, pageSize);
        model.addAttribute("orders", orderRepo.findByUserOrderByPlacedAtDesc(user));
        return "orderList";
    }*/

    @PostMapping
    public String processOrder(@Valid Order order, Errors errors, SessionStatus sessionStatus, @AuthenticationPrincipal User user) {
        if (errors.hasErrors()) {
            return "orderForm";
        }
        order.setUser(user);
        orderRepo.save(order);
        sessionStatus.setComplete();
        return "redirect:/";
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }


/*    @Autowired
    private UserRepository userRepository;

    @PostMapping // еще способ получить User через Principal
    public String processOrder(@Valid Order order, Errors errors, SessionStatus sessionStatus, Principal principal) {
        if (errors.hasErrors()) {
            return "orderForm";
        }
        User user = userRepository.findByUsername(principal.getName());
        order.setUser(user);
        orderRepo.save(order);
        sessionStatus.setComplete();
        return "redirect:/";
    }*/

/*    @PostMapping // еще способ получить User через Authentication
    public String processOrder(@Valid Order order, Errors errors, SessionStatus sessionStatus, Authentication authentication) {
        if (errors.hasErrors()) {
            return "orderForm";
        }
        User user = (User) authentication.getPrincipal();
        order.setUser(user);
        orderRepo.save(order);
        sessionStatus.setComplete();
        return "redirect:/";
    }*/
}
