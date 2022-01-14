package com.py.mcsusers.repository;

import com.py.mcsusers.dto.UserDto;
import com.py.mcsusers.dto.rowmapper.UserRowMapper;
import com.py.mcsusers.util.BuildCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.*;

@Repository
public class UserRepository extends JdbcDaoSupport {

    private final String GET_USER_BY_ID = "SELECT USER_CODE AS USER_CODE, USER_NAME AS USER_NAME, " +
            "USER_LAST_NAME AS USER_LAST_NAME, USER_LOGIN_NAME AS USER_LOGIN_NAME, USER_PASSWORD AS USER_PASSWORD," +
            " USER_EMAIL AS USER_EMAIL, USER_STATUS AS USER_STATUS FROM public.\"user\" WHERE USER_CODE = ? ";

    private final String GET_USER_ALL = "SELECT USER_CODE AS USER_CODE, USER_NAME AS USER_NAME, " +
            "USER_LAST_NAME AS USER_LAST_NAME, USER_LOGIN_NAME AS USER_LOGIN_NAME, USER_PASSWORD AS USER_PASSWORD," +
            " USER_EMAIL AS USER_EMAIL, USER_STATUS AS USER_STATUS FROM public.\"user\" ";
    private static final String GET_USER_BY_LIST = "SELECT USER_CODE AS USER_CODE, USER_NAME AS USER_NAME, " +
            "USER_LAST_NAME AS USER_LAST_NAME, USER_LOGIN_NAME AS USER_LOGIN_NAME, USER_PASSWORD AS USER_PASSWORD," +
            " USER_EMAIL AS USER_EMAIL, USER_STATUS AS USER_STATUS FROM public.\"user\" ";
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public void initialize(@Qualifier("datasourcepostgres")DataSource dataSource){
        this.setDataSource(dataSource);
    }
    public Optional<UserDto> getUserByCode(Integer id){
        return Optional.ofNullable(jdbcTemplate.queryForObject(GET_USER_BY_ID, new UserRowMapper(),id));
    }
    public List<UserDto> getUserAll(){
        List<UserDto> listUserDto = jdbcTemplate.query(GET_USER_ALL,new UserRowMapper());
        return listUserDto;
    }
    public List<UserDto> getUserByList(List<Integer> listId) {
        List<UserDto> listUserDto = new ArrayList<>();
        try {
            if (listId.isEmpty()) {
                listUserDto = jdbcTemplate.query(GET_USER_ALL, new UserRowMapper());

            } else {
                StringBuilder statementSQL = new StringBuilder(UserRepository.GET_USER_BY_LIST);
                List<Object> param = new LinkedList();
                Map<String, Object> map = new LinkedHashMap();
                map.put(" USER_CODE = ?", listId);
                StringBuilder where = BuildCondition.buildConditionWhere(map, param, new StringBuilder());
                statementSQL.append(where.toString());
                String queryStatement = statementSQL.toString();
                listUserDto = jdbcTemplate.query(queryStatement, new UserRowMapper(), listId.toArray());

            }
        } catch (Exception e){
            System.out.print(e.getMessage());
        }
        return listUserDto;
    }


}

