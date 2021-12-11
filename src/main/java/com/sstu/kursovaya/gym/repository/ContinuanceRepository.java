package com.sstu.kursovaya.gym.repository;

import com.sstu.kursovaya.gym.model.Continuance;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContinuanceRepository {
    final JdbcTemplate jdbc;

    RowMapper<Continuance> mapper = (rs, rowNum) -> new Continuance()
            .setId(rs.getInt("id"))
            .setDays(rs.getInt("days"))
            .setType(rs.getString("type"));

    public ContinuanceRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    private Continuance one(String sql, Object... args) {
        var res = jdbc.query(sql, mapper, args);
        return res.size() == 0 ? null : res.get(0);
    }

    public Continuance get(int id) {
        return one("call getCONTINUANCEById(?)", id);
    }

    public List<Continuance> getAll() {
        return jdbc.query("call getAllCONTINUANCE()", mapper);
    }

    public void create(Continuance continuance) {
        System.out.println(continuance);
        jdbc.update("call createCONTINUANCE(?,?)", continuance.getDays(), continuance.getType());
    }

    public void delete(int id) {
        jdbc.update("call deleteCONTINUANCE(?)", id);
    }
}
