package com.example.tarot.controller;

import com.example.tarot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 로그인 페이지
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    // 회원가입 페이지
    @GetMapping("/join")
    public String joinPage() {
        return "join";
    }

    // 회원가입 처리
    @PostMapping("/joinProc")
    public String joinProcess(String username, String password, String name) {
        userService.join(username, password, name);
        return "redirect:/login";
    }
}
