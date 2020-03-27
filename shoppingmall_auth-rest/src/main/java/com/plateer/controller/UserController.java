package com.plateer.controller;

import com.plateer.controller.utils.TokenUtil;
import com.plateer.domain.User;
import com.plateer.service.JwtService;
import com.plateer.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseCookie;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
@RequestMapping("/api/user")
@CrossOrigin(allowCredentials = "true", origins = {"*"}, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT},
        allowedHeaders = {"Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
                "Access-Control-Request-Headers", "Access-Control-Allow-Origin", "Set-Cookie","token"},
        exposedHeaders = {"Access-Control-Allow-Origin", "Access-Control-Allow-Credentials","token"}, maxAge = 3000)
public class UserController {

    UserService userService;
    JwtService jwtService;
    TokenUtil tokenUtil;

    public UserController(UserService userService, JwtService jwtService, TokenUtil tokenUtil) {
        this.userService = userService;
        this.jwtService = jwtService;
        this.tokenUtil = tokenUtil;
    }

    /**
     * 회원가입
     * @param user
     */
    @PostMapping("/signUp")
    public void signUp(@RequestBody User user) {
        userService.signUp(user);
    }

    /**
     * 로그인
     * @param user
     * @param response
     * @return
     */
    @PostMapping("/login")
    public String login(@RequestBody User user, HttpServletResponse response) {
        String msg;
        try {
            msg = userService.validateUser(user);
            if (msg.equals("success")) {
                String token = jwtService.create("member", user.getEmail(), "user");

                ResponseCookie cookie = ResponseCookie.from("token", token)
                        .build();

                response.addHeader("Set-Cookie", cookie.toString());
                //response.addHeader("token", cookie.toString());
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return "failed";
        }
        return msg;
    }

    @GetMapping
    public String getUserInfo(){
        tokenUtil.getUserEmail();
        return "";
    }
}
