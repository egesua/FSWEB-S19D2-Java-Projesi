package com.workintech.S19D2.service;

import com.workintech.S19D2.entity.Member;
import com.workintech.S19D2.entity.Role;
import com.workintech.S19D2.repository.MemberRepository;
import com.workintech.S19D2.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AuthenticationService {

    private final MemberRepository memberRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public Member register(String email, String password){
        Optional<Member> byEmail = memberRepository.findByEmail(email);
        if(byEmail.isPresent()){
            throw new RuntimeException("User with given email already exists! Email: " +email);
        }

        String encodedPassword = passwordEncoder.encode(password);

        Role userRole = roleRepository.findByAuthority("USER").get();
        Role adminRole = roleRepository.findByAuthority("ADMIN").get();
        List<Role> roleList = new ArrayList<>();
        roleList.add(userRole);
        roleList.add(adminRole);

        Member member = new Member();
        member.setEmail(email);
        member.setPassword(encodedPassword);
        member.setRoles(roleList);
        return memberRepository.save(member);
    }
}
