package com.peerlearn.peerlearn.modules.user;


import com.peerlearn.peerlearn.modules.user.dtos.UserGetDto;
import com.peerlearn.peerlearn.modules.user.dtos.UserLoginDto;
import com.peerlearn.peerlearn.modules.user.dtos.UserSignupDto;
import com.peerlearn.peerlearn.modules.user.dtos.UserTokenDto;
import com.peerlearn.peerlearn.response.auth.LoginSuccessResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

@RestController
@RequestMapping("/users")
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signin")
    ResponseEntity<UserTokenDto> signin(@Valid @RequestBody UserLoginDto userLoginDto){
        return new  ResponseEntity<UserTokenDto>(userService.login(userLoginDto.getEmail(),userLoginDto.getPassword()), HttpStatus.OK);
    }

    @PostMapping("/signup")
    ResponseEntity<UserGetDto> signup(@Valid @RequestBody UserSignupDto userSignupDto){
        System.out.println("signup : " +userSignupDto);
        return new  ResponseEntity<UserGetDto>(userService.signup(userSignupDto), HttpStatus.OK);
    }


    @GetMapping
    void doo(){
        System.out.println("on doo");
    }
}
