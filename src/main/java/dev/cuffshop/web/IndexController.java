package dev.cuffshop.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cuffshop")
public class IndexController {


    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/without-mockup")
    public String withoutMockup() {
        return "mobile-mockup/without-mockup";
    }

    @GetMapping("/preloading")
    public String preloading() {
        return "preloading";
    }

    @GetMapping("/search")
    public String search() {
        return "cuffshop/search";
    }

}
