package com.example.filterexam.filterexam4.Service;

import com.example.filterexam.filterexam4.entitiy.Role;
import com.example.filterexam.filterexam4.entitiy.User;
import com.example.filterexam.filterexam4.repository.RoleRepository;
import com.example.filterexam.filterexam4.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserService {
   private final UserRepository userRepository;
   private final RoleRepository roleRepository;

   public User registerNewUser(User user) {
       Role userRole = roleRepository.findByName("ROLE_USER");
       user.setRoles(Collections.singleton(userRole));
       return userRepository.save(user);

   }
}
