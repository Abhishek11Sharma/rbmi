package com.rbmi.student.portal.rbmi.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogInDto {
    
    private String username;
    private String password;
}
