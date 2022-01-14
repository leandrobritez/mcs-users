package com.py.mcsusers.dto.rowmapper;

import com.py.mcsusers.dto.UserDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<UserDto> {
    private static final String USER_CODE = "user_code";
    private static final String USER_NAME = "user_name";
    private static final String USER_LAST_NAME = "user_last_name";
    private static final String USER_LOGIN_NAME = "user_login_name";
    private static final String USER_PASSWORD = "user_password";
    private static final String USER_EMAIL = "user_email";
    private static final String USER_STATUS = "user_status";
    @Override
    public UserDto mapRow(ResultSet resultSet, int i) throws SQLException {
        UserDto userDto = new UserDto();
        userDto.setUserCode(resultSet.getInt(USER_CODE));
        userDto.setUserName(resultSet.getString(USER_NAME));
        userDto.setUserLastName(resultSet.getString(USER_LAST_NAME));
        userDto.setUserLoginName(resultSet.getString(USER_LOGIN_NAME));
        userDto.setUserPassword(resultSet.getString(USER_PASSWORD));
        userDto.setUserEmail(resultSet.getString(USER_EMAIL));
        userDto.setUserStatus(resultSet.getString(USER_STATUS));
        return userDto;
    }
}
