package com.py.mcsusers.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Column;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User implements Serializable {
    @JsonProperty("user_code")
    private Integer userCode;
    @JsonProperty("user_name")
    private String userName;
    @JsonProperty("user_last_name")
    private String userLastName;
    @JsonProperty("user_login_name")
    private String userLoginName;
    @JsonProperty("user_password")
    private String userPassword;
    @JsonProperty("user_email")
    private String userEmail;
    @JsonProperty("user_status")
    private String userStatus;
}
