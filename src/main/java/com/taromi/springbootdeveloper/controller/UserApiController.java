package com.taromi.springbootdeveloper.controller;

import com.taromi.springbootdeveloper.dto.AddUserRequest;
import com.taromi.springbootdeveloper.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserApiController {
    private final UserService userService;

    @PostMapping("/user")
    public String signup(AddUserRequest request) {
        userService.save(request); // 회원가입 메서드 호출
        return "redirect:/login"; // 로그인 페이지로 리다이렉트
    }
}
