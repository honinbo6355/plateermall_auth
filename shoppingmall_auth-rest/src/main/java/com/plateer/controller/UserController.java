package com.plateer.controller;

import com.plateer.domain.dto.LoginDto;
import com.plateer.domain.dto.UserDto;
import com.plateer.service.JwtService;
import com.plateer.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import sun.rmi.runtime.Log;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/user")
@CrossOrigin(allowCredentials = "true", origins = {"*"}, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT},
        allowedHeaders = {"Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
                "Access-Control-Request-Headers", "Access-Control-Allow-Origin", "Set-Cookie"},
        exposedHeaders = {"Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"}, maxAge = 3000)
public class UserController {

    private static final String HEADER_AUTH = "Authorization";

    UserService userService;
    JwtService jwtService;
    ModelMapper modelMapper;

    public UserController(UserService userService, JwtService jwtService) {
        this.userService = userService;
        this.jwtService = jwtService;
    }

    @GetMapping
    public LoginDto getUser() {
        long memberId = jwtService.getMemberId();
        //Optional<UserDto> loginUsers = userRepository.findById(memberId);
        return modelMapper.map(new UserDto("eks4116@gmail.com", "danbi", "password", "01047264128"), LoginDto.class);
    }

    /**
     * Vue페이지에서 router & axios 호출 후 interceptor로 token 유효성확인
     * @param token
     * @return
     */
    @PostMapping("/getUser")
    public UserDto getUserFromClient(@RequestBody String token) {
        log.info("/getUserFromClient 실행실행");
        Map<String, Object> result = jwtService.get("member", token);

        return null;
    }

    @GetMapping("/{email}")
    public UserDto getUser(@PathVariable String email) {
        return new UserDto(email, "name", "password", "phoneNumber");
    }

    @PostMapping(path = "/login")
    public String login(@RequestBody UserDto user, HttpServletResponse response) {
        UserDto loginUsers;
        try {
            //loginUsers = userService.signin(user.getEmail(), user.getPassword());
            loginUsers = new UserDto("eks4116@gmail.com", "danbi", "password", "01047264128");
            String token = jwtService.create("member", loginUsers, "user");
            response.setHeader(HEADER_AUTH, "Bearer " + token);
            return token;
        } catch (Exception e) {
            return "failed";
        }
    }

}
