package dev.cuffshop.test.web.login;

import dev.cuffshop.test.domain.login.BasicLoginService;
import dev.cuffshop.test.domain.member.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class BasicLoginController {

    private final BasicLoginService loginService;

    @GetMapping("/login")
    public String loginForm(@ModelAttribute("loginForm") BasicLoginForm form) {
        return "basic/login/loginForm";
    }

    @PostMapping("/login")
    public String login(@Validated @ModelAttribute BasicLoginForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "basic/login/loginForm";
        }

        Member loginMember = loginService.login(form.getLoginId(), form.getPassword());
        if (loginMember == null) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "basic/login/loginForm";
        }

        //로그인 성공 처리 TODO
        return "redirect:/basic/home";
    }


}
