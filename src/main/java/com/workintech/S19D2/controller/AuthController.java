package com.workintech.S19D2.controller;

import com.workintech.S19D2.dto.RegistrationMember;
import com.workintech.S19D2.entity.Member;
import com.workintech.S19D2.repository.MemberRepository;
import com.workintech.S19D2.service.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@AllArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public Member register(@RequestBody RegistrationMember registrationMember){
        return authenticationService.register(registrationMember.email(), registrationMember.password());
    }
}
