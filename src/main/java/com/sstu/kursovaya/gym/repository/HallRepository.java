package com.sstu.kursovaya.gym.repository;

import com.sstu.kursovaya.gym.model.Hall;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HallRepository {
    final JdbcTemplate jdbc;


    public HallRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    RowMapper<Hall> mapper = (rs, rowNum) -> new Hall()
            .setId(rs.getInt("id"))
            .setName(rs.getString("name"));

    private Hall one(String sql, Object... args) {
        var res = jdbc.query(sql, mapper, args);
        return res.size() == 0 ? null : res.get(0);
    }

    public Hall get(int id) {
        return one("call getHallById(?)", id);
    }

    public List<Hall> getAll() {
        return jdbc.query("call getAllHall()", mapper);
    }

    public void create(Hall hall) {
        jdbc.update("call createHall(?)", hall.getName());
    }

    public void delete(int id) {
        jdbc.update("call deleteHall(?)", id);
    }
}
