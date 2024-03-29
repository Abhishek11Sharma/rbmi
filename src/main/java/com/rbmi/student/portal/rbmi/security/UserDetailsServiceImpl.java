package com.rbmi.student.portal.rbmi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.rbmi.student.portal.rbmi.entities.CustomUserDetails;
import com.rbmi.student.portal.rbmi.entities.User;
import com.rbmi.student.portal.rbmi.repositories.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.debug("Entering in loadUserByUsername Method...");
        try {
            User user = userRepository.findByEmail(username);
            if(user == null){
                log.error("Username not found: " + username);
                throw new UsernameNotFoundException("could not found user..!!");
            }

            return new CustomUserDetails(user);
        } catch (Exception e) {
             e.printStackTrace();
             throw e;
        }
    }
}