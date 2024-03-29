package com.rbmi.student.portal.rbmi.entities;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String roll_no;

    @Column(nullable = false)
    private String first_name;

    @Column(nullable = false)
    private String middle_name;

    @Column(nullable = false)
    private String last_name;

    @Column(nullable = false)
    private String college_id;

    @Column(nullable = false)
    private String college_name;

    @Column(nullable = false)
    private String student_id;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false)
    private String phone_no;

    @Column(nullable = false)
    private String course;

    @Column(nullable = false)
    private String branch;

    @Column(nullable = false)
    private String duration_of_course;

    @Column(nullable = false)
    private char status;

    @Column(nullable = false)
    private String password;
}
