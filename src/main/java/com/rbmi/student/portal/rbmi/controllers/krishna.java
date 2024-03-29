package com.rbmi.student.portal.rbmi.controllers;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class krishna {
    
    @GetMapping("aa")
    public String test(Principal principal){
        System.out.println(principal.getName());
        return "krishna";
    }
}
