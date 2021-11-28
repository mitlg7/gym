package com.sstu.kursovaya.gym.repository;

import com.sstu.kursovaya.gym.model.Admin;
import com.sstu.kursovaya.gym.model.Trainer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TrainerRepository {
    final JdbcTemplate jdbc;

    public TrainerRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    RowMapper<Trainer> mapper = (rs, rowNum) -> new Trainer()
            .setId(rs.getInt("id"))
            .setName(rs.getString("name"))
            .setBirthday(rs.getDate("birthdate"))
            .setGender(rs.getString("type"))
            .setPosition(rs.getString("position"));

    private Trainer one(String sql, Object... args) {
        var res = jdbc.query(sql, mapper, args);
        return res.size() == 0 ? null : res.get(0);
    }

    public Trainer get(int id) {
        return one("call getTrainerById(?)", id);
    }

    public List<Trainer> getAll() {
        return jdbc.query("call getAllTrainers()",mapper);
    }

    public void create(Trainer trainer) {
        jdbc.update("call createTrainer(?,?,?,?,?)",
                trainer.getName(),
                trainer.getPhone(),
                trainer.getPosition(),
                trainer.getBirthday(),
                trainer.getGender()
        );
    }

    public void delete(int id) {
        jdbc.update("call deleteTrainer(?)", id);
    }
}
