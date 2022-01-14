package com.py.mcsusers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    @Column(value = "user_code")
    private Integer userCode;
    @Column(value = "user_name")
    private String userName;
    @Column(value= "userLastName")
    private String userLastName;
    @Column(value = "user_login_name")
    private String userLoginName;
    @Column(value = "user_password")
    private String userPassword;
    @Column(value = "user_email")
    private String userEmail;
    @Column("user_status")
    private String userStatus;
}
