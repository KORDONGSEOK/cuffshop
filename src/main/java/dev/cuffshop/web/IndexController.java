package dev.cuffshop.web;

import dev.cuffshop.domain.member.Member;
import dev.cuffshop.repository.member.MemberRepository;
import dev.cuffshop.web.session.SessionConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequestMapping("/cuffshop")
public class IndexController {

    private final MemberRepository memberRepository;

    @Autowired
    public IndexController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @GetMapping
    public String homeLogin(
            @SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member loginMember, Model model) {

        if (loginMember == null) {
            return "redirect:/cuffshop/login";
        }

        model.addAttribute("member", loginMember);
        return "redirect:/cuffshop/products";
    }

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
