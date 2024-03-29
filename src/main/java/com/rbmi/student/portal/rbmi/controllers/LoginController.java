package com.rbmi.student.portal.rbmi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rbmi.student.portal.rbmi.apiResponse.ApiResponse;
import com.rbmi.student.portal.rbmi.payloads.LogInDto;
import com.rbmi.student.portal.rbmi.payloads.ResultDto;
import com.rbmi.student.portal.rbmi.security.JwtService;

import lombok.Builder;

@RestController
@RequestMapping("/api/")
@Builder
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody LogInDto authRequestDTO) {
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authRequestDTO.getUsername(), authRequestDTO.getPassword()));
            if (authentication.isAuthenticated()) {
                return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("Token created", true,
                        List.of(new ResultDto("Access _Token",
                                jwtService.GenerateToken(authRequestDTO.getUsername())))));
            } else {
                throw new UsernameNotFoundException("invalid user request..!!");
            }
        } catch (BadCredentialsException e) {
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
