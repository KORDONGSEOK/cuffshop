package dev.cuffshop.test.web.member;

import dev.cuffshop.test.domain.member.Member;
import dev.cuffshop.test.domain.member.BasicMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;

@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class BasicMemberController {

    private final BasicMemberRepository memberRepository;

    @GetMapping("/add")
    public String addForm(@ModelAttribute("member") Member member) {
        return "basic/members/addMemberForm";
    }

    @PostMapping("/add")
    public String save(@Validated @ModelAttribute Member member, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "basic/members/addMemberForm";
        }
        memberRepository.save(member);
        return "redirect:/basic/home";
    }


    /**
     * 테스트용 데이터 추가
     */
    @PostConstruct
    public void init() {
        memberRepository.save(new Member("test", "테스터", "1234"));
    }

}
