package org.bearer.controller;

import org.bearer.service.LoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public String weChatLogin(@RequestParam("code") String code) {
        return loginService.weChatLogin(code);
    }
}
