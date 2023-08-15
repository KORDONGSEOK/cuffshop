package dev.cuffshop.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/basic/home")
    public String home() {
        return "basic/home";
    }
}
