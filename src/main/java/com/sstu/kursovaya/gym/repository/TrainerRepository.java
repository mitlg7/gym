package com.sstu.kursovaya.gym.repository;

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

    public Trainer get(int id){
        return null;
    }

    public List<Trainer> getAll(){
        return null;
    }

    public void create(Trainer trainer){

    }
}
