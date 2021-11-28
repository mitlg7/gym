package com.sstu.kursovaya.gym.repository;

import com.sstu.kursovaya.gym.model.Gender;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GenderRepository {
    final JdbcTemplate jdbc;

    public GenderRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    RowMapper<Gender> mapper = (rs, rowNum) -> new Gender()
            .setId(rs.getInt("id"))
            .setType(rs.getString("type"));

    private Gender one(String sql, Object... args) {
        var res = jdbc.query(sql, mapper, args);
        return res.size() == 0 ? null : res.get(0);
    }

    public List<Gender> getAll() {
        return jdbc.query("call getAllGender()", mapper);
    }

    public Gender get(int id) {
        return one("call getGender(?)", id);
    }
}
