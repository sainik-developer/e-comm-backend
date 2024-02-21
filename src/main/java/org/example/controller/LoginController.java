package org.example.controller;

import lombok.extern.java.Log;
import org.example.entity.UserDO;
import org.example.dto.LoginCredentialDTO;
import org.example.repository.UserRepository;
import org.example.advice.LoginException;
import org.example.services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Log
@RestController
@CrossOrigin("*")
public class LoginController {
    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserRepository userRepository;


    @CrossOrigin("*")
    @PostMapping("/api/login")
    public String login(@RequestBody LoginCredentialDTO credential) throws LoginException {
        UserDO userDO = userRepository.findByUserName(credential.getEmail());
        if (userDO != null && userDO.getPassword().equals(credential.getPassword())) {
            return jwtService.createToken(jwtService.userClaims(credential.getEmail()));
        }
        throw new LoginException();
    }
}
