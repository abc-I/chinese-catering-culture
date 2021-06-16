package org.bearer.controller;

import org.bearer.entity.dto.UserLogin;
import org.bearer.service.LoginService;
import org.springframework.web.bind.annotation.*;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/15 9:20
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/weChatLogin")
    public String weChatLogin(@RequestBody UserLogin userLogin) {
        return loginService.weChatLogin(userLogin);
    }
}