package com.sstu.kursovaya.gym.repository;

import com.sstu.kursovaya.gym.model.Admin;
import com.sstu.kursovaya.gym.repository.utils.NotFoundException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class AdminRepository {
    final JdbcTemplate jdbc;

    RowMapper<Admin> mapperAdmin = (rs, rowNum) -> new Admin()
            .setId(rs.getInt("id"))
            .setLogin(rs.getString("login"))
            .setPassword(rs.getString("password"));


    private Admin one(String sql, Object... args) {
        var res = jdbc.query(sql, mapperAdmin, args);
        return res.size() == 0 ? null : res.get(0);
    }


    public AdminRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Admin get(String login) {
        var res = one("call getAdminByLogin(?)", login);
        if (res == null)
            throw new NotFoundException("Admin with login " + login + " not found");
        return res;
    }
}
