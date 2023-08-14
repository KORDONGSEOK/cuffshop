package dev.cuffshop.web.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

    @GetMapping("/cuffshop/join")
    public String join() {
        return "cuffshop/member/signup";
    }

    @GetMapping("/cuffshop/login")
    public String login() {
        return "cuffshop/member/signin";
    }

    @GetMapping("/cuffshop/mypage")
    public String mypage() {
        return "cuffshop/member/mypage";
    }
}
