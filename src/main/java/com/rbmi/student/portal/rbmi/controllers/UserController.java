package com.rbmi.student.portal.rbmi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rbmi.student.portal.rbmi.apiResponse.ApiResponse;
import com.rbmi.student.portal.rbmi.payloads.ResultDto;
import com.rbmi.student.portal.rbmi.payloads.UserDto;
import com.rbmi.student.portal.rbmi.services.UserService;

@RequestMapping("/api/")
@RestController
public class UserController {

    @Autowired
    private UserService userService;
    
    @PostMapping("user")
    public ResponseEntity<?> saveUser(@RequestBody UserDto userDto)
    {
        String id=userService.saveUser(userDto);
        if (id==null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("User did't save into database",false,List.of(new ResultDto())));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("User have been saved successfully",true,List.of(new ResultDto("id",id))));
    }
}
