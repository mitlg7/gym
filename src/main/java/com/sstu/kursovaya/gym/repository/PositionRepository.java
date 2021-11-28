package com.sstu.kursovaya.gym.repository;

import com.sstu.kursovaya.gym.model.Admin;
import com.sstu.kursovaya.gym.model.Position;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PositionRepository {
    final JdbcTemplate jdbc;

    public PositionRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
    RowMapper<Position> mapper = (rs, rowNum) -> new Position()
            .setId(rs.getInt("id"))
            .setType(rs.getString("type"));

    private Position one(String sql, Object... args) {
        var res = jdbc.query(sql, mapper, args);
        return res.size() == 0 ? null : res.get(0);
    }

    public void create(Position position){
        jdbc.update("call createPosition(?)", position.getType());
    }

    public void delete(int id){
        jdbc.update("call deletePosition(?)", id);
    }

    public Position get(int id){
        return one("call getPosition(?)", id);
    }

    public List<Position> getAll(){
        return jdbc.query("call getAllPosition()", mapper);
    }
}
