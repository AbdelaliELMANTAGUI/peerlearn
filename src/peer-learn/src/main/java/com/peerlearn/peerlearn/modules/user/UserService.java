package com.peerlearn.peerlearn.modules.user;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.peerlearn.peerlearn.errors.exceptions.UserNotExistException;
import com.peerlearn.peerlearn.errors.exceptions.UserPasswordNotMatchException;
import com.peerlearn.peerlearn.modules.user.dtos.UserGetDto;
import com.peerlearn.peerlearn.modules.user.dtos.UserSignupDto;
import com.peerlearn.peerlearn.modules.user.dtos.UserTokenDto;
import com.peerlearn.peerlearn.modules.user.dtos.UserTokenPayloadDto;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    final UserRepository userRepository;
    final PasswordEncoder passwordEncoder;
    final UserMapper userMapper;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    public UserTokenDto login(String email, String pass){
        Optional<User> found = userRepository.findUserByEmail(email);
        User user = found.orElseThrow(()-> new UserNotExistException("USer not found with these credentials "+email+" , "+pass));
        if(!passwordEncoder.matches(pass,user.getPassword())){
            throw new UserPasswordNotMatchException("User Password doesn't matches "+pass);
        }
        Algorithm algorithm = Algorithm.HMAC256("secret");
        Map<String, Long> payload = new HashMap<String, Long>();
        payload.put("id",user.getId());
        String token = JWT.create()
                .withPayload(payload)
                .sign(algorithm);
        return new UserTokenDto(token);
    }

    public UserGetDto signup(UserSignupDto userSignupDto){
        User newUser = userMapper.userSignupDtoToUser(userSignupDto);
        System.out.println("newUSer "+newUser);
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        return userMapper.userToUserGetDto(userRepository.save(newUser));
    }
}
