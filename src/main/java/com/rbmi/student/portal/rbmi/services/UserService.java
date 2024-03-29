package com.rbmi.student.portal.rbmi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rbmi.student.portal.rbmi.entities.User;
import com.rbmi.student.portal.rbmi.payloads.UserDto;
import com.rbmi.student.portal.rbmi.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String saveUser(UserDto userDto)
    {
        User user = new User();
        user.setBranch(userDto.getBranch());
        user.setCollege_id(userDto.getCollege_id());
        user.setCollege_name(userDto.getCollege_name());
        user.setCourse(userDto.getCourse());
        user.setDuration_of_course(userDto.getDuration_of_course());
        user.setEmail(userDto.getEmail());
        user.setFirst_name(userDto.getFirst_name());
        user.setLast_name(userDto.getLast_name());
        user.setMiddle_name(userDto.getMiddle_name());
        user.setPassword(passwordEncoder.encode("rbmi"));
        user.setPhone_no(userDto.getPhone_no());
        user.setRoll_no(userDto.getRoll_no());
        user.setStatus('N');
        user.setStudent_id(userDto.getStudent_id());

        try {
            User userObj=userRepository.save(user);
            if (userObj==null) {
                return null;
            }
            return userObj.getId().toString();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
