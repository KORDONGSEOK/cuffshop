package dev.cuffshop.web.member;

import dev.cuffshop.domain.member.Member;
import dev.cuffshop.repository.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;

@Controller
@RequestMapping("/cuffshop")
public class MemberController {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @GetMapping("/join")
    public String joinForm(@ModelAttribute("member")MemberSaveForm form) {
        return "cuffshop/member/signup";
    }

    @PostMapping("/join")
    public String joinSave(@Validated @ModelAttribute("member") MemberSaveForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "cuffshop/member/signup";
        }

        Member member = new Member(form.getEmail(), form.getPassword());

        memberRepository.save(member);
        return "redirect:/cuffshop/login";
    }

    @GetMapping("/login")
    public String login() {
        return "cuffshop/member/signin";
    }

    @GetMapping("/mypage")
    public String mypage() {
        return "cuffshop/member/mypage";
    }

    /**
     * 테스트용 데이터 추가
     */

    @PostConstruct
    public void init() {
        memberRepository.save(new Member("chas0302@naver.com", "1234"));
    }
}
