package com.co.kr.develog;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(HttpSession session) {

        Object loginUser = session.getAttribute("loginUser");

        if (loginUser == null) {
            return "redirect:/login";  // 로그인 필요
        }

        return "index";  // 정상 접근
    }


}
