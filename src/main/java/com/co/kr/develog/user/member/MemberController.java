package com.co.kr.develog.user.member;

import com.co.kr.develog.user.member.LoginForm;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("LoginForm", new LoginForm());
        return "views/user/login";
    }

    @GetMapping("/member")
    public String memberForm(Model model) {
        model.addAttribute("memberForm", new MemberForm());
        return "views/user/member";
    }

    @PostMapping("/user/memberCreate")
    public String createMember(@Valid MemberForm form, BindingResult bindingResult, Model model) {

        memberService.createMember(form);
        model.addAttribute("LoginForm", new LoginForm());
        return "views/user/login";
    }

    @PostMapping("/user/login")
    public String login(
            @Valid LoginForm form,
            BindingResult bindingResult,
            Model model,
            HttpSession session) {

        LoginResult result = memberService.login(form);
        System.out.println(result.toString());

        if (result == null) {
            System.out.println("@@");
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 올바르지 않습니다.");
            return "views/user/login";
        }

        session.setAttribute("loginUser", result);
        model.addAttribute("member", result);

        return "index";
    }
}
