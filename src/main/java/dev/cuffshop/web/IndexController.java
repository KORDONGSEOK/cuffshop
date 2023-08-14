package dev.cuffshop.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/cuffshop/without-mockup")
    public String withoutMockup() {
        return "mobile-mockup/without-mockup";
    }

    @GetMapping("/cuffshop/preloading")
    public String preloading() {
        return "preloading";
    }

    @GetMapping("/cuffshop/search")
    public String search() {
        return "cuffshop/search";
    }

}
