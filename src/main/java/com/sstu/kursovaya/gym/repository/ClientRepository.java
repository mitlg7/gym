package com.sstu.kursovaya.gym.repository;

import com.sstu.kursovaya.gym.model.Admin;
import com.sstu.kursovaya.gym.model.Client;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientRepository {
    final JdbcTemplate jdbc;

    public ClientRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    RowMapper<Client> mapper = (rs, rowNum) -> new Client()
            .setId(rs.getInt("id"))
            .setFirstName(rs.getString("firstname"))
            .setLastname(rs.getString("lastname"))
            .setPhone(rs.getString("phone"))
            .setRegistration(rs.getDate("registration"))
            .setBirthday(rs.getDate("birthday"))
            .setActive(rs.getBoolean("active"));

    private Client one(String sql, Object... args) {
        var res = jdbc.query(sql, mapper, args);
        return res.size() == 0 ? null : res.get(0);
    }

    public List<Client> getAll() {
        return jdbc.query("call getAllClients()", mapper);
    }

    public void create(Client client) {
        jdbc.update("call createClient(?,?,?,?,?,?)",
                client.getFirstName(),
                client.getLastname(),
                client.getPhone(),
                client.getBirthday(),
                client.getRegistration(),
                client.getGender()
        );
    }

    public void delete(int id){
        jdbc.update("call deleteClient(?)", id);
    }
}
