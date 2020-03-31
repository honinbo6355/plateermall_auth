package com.plateer.controller;

import com.plateer.domain.User;
import com.plateer.service.JwtService;
import com.plateer.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
@RequestMapping("/api/user")
@CrossOrigin(allowCredentials = "true", origins = {"*"}, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT},
        allowedHeaders = {"Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
                "Access-Control-Request-Headers", "Access-Control-Allow-Origin", "Set-Cookie", "Authorization"},
        exposedHeaders = {"Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"}, maxAge = 3000)
public class UserController {

    UserService userService;
    JwtService jwtService;

    public UserController(UserService userService, JwtService jwtService) {
        this.userService = userService;
        this.jwtService = jwtService;
    }

    @PostMapping("/signUp")
    public void signUp(@RequestBody User user) {
        userService.signUp(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user, HttpServletResponse response) {
        String msg;
        try {
            msg = userService.validateUser(user);
            if (msg.equals("success")) {
                User loginUser = userService.getUserByEmail(user.getEmail());
                String token = jwtService.create("member", loginUser);
                response.setHeader("Authorization", "Bearer " + token);
                return token;
            }
        } catch (Exception e) {
            return "failed";
        }
        return msg;
    }

    @GetMapping("/getCurrentUserInfo")
    public User getCurrentUserInfo() {
        return userService.getCurrentUserInfo();
    }

    @PutMapping("/updateUserInfo")
    public void updateUserInfo(@RequestBody User user){
        userService.updateUserInfo(user);
    }

    @GetMapping("/duplicateCheck/{email}")
    public boolean duplicateCheck(@PathVariable String email){
        return userService.getUserByEmail(email) != null;
    }
}
