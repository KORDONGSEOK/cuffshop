package dev.cuffshop.web.member;

import dev.cuffshop.domain.member.DayCode;
import dev.cuffshop.domain.member.Member;
import dev.cuffshop.domain.member.MonthCode;
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
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/cuffshop")
public class MemberController {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @ModelAttribute("monthCodes")
    public List<MonthCode> monthCodes() {
        List<MonthCode> monthCodes = new LinkedList<>();
        for(int i=1; i<= 12; i++){
            String month = String.format("%02d", i);
            monthCodes.add(new MonthCode(month, month + "월"));
        }
        return monthCodes;
    }

    @ModelAttribute("dayCodes")
    public List<DayCode> dayCodes() {
        List<DayCode> dayCodes = new LinkedList<>();
        for(int i=1; i<=31; i++){
            String day = String.format("%02d",i);
            dayCodes.add(new DayCode(day, day + "일"));
        }
        return dayCodes;
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

        Member member = new Member(form.getEmail(),
                                    form.getPassword(),
                                    form.getYear(),
                                    form.getMonthCode(),
                                    form.getDayCode(),
                                    form.getPhoneNumber());

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
