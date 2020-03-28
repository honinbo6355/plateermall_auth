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

//    @GetMapping
//    public LoginDto getUser() {
//        long memberId = jwtService.getMemberId();
//        //Optional<UserDto> loginUsers = userRepository.findById(memberId);
//        return modelMapper.map(new User("eks4116@gmail.com", "danbi", "password", "01047264128"), LoginDto.class);
//    }

    /**
     * Vue페이지에서 router & axios 호출 후 interceptor로 token 유효성확인
     * @param token
     * @return
     */
//    @PostMapping("/getUser")
//    public User getUserFromClient(@RequestBody String token) {
//        log.info("/getUserFromClient 실행실행");
//        Map<String, Object> result = jwtService.get("member", token);
//
//        return null;
//    }
//
//


}
