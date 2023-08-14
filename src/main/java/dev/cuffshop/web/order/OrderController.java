package dev.cuffshop.web.order;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {

    @GetMapping("/cuffshop/cart")
    public String carts() {
        return "cuffshop/order/cart";
    }
}
