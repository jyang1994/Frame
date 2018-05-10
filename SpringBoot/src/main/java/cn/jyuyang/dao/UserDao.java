package cn.jyuyang.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(String username) {
        String sql = "insert into user (name) value (?)";
        jdbcTemplate.update(sql,username);
    }

}