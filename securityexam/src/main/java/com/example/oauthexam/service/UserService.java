package com.example.oauthexam.service;

import com.example.oauthexam.domain.Role;
import com.example.oauthexam.domain.User;
import com.example.oauthexam.repository.RoleRepository;
import com.example.oauthexam.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    //롤과 PW 인코딩을 추가해서 DB에 넣어준다.
    public User registUser(User user) {
        //롤추가
        Role role = roleRepository.findByName("USER");
        user.setRoles(Collections.singleton(role));
        //패스워드 인코딩 하여 추가
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

}
