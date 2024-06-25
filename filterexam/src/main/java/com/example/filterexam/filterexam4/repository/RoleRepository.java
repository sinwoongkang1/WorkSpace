package com.example.filterexam.filterexam4.repository;

import com.example.filterexam.filterexam4.entitiy.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
