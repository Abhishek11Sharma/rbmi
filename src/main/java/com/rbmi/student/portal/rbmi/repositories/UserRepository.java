package com.rbmi.student.portal.rbmi.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rbmi.student.portal.rbmi.entities.User;

public interface UserRepository extends JpaRepository<User,UUID> {
    
    public User findByEmail(String username);

}
