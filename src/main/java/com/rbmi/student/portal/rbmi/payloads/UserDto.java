package com.rbmi.student.portal.rbmi.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    
    private String roll_no;

    private String first_name;

    private String middle_name;

    private String last_name;

    private String college_id;

    private String college_name;

    private String student_id;

    private String email;

    private String phone_no;

    private String course;

    private String branch;

    private String duration_of_course;

}
