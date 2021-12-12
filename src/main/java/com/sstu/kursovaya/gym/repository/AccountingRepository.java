package com.sstu.kursovaya.gym.repository;

import com.sstu.kursovaya.gym.model.Accounting;
import com.sstu.kursovaya.gym.model.utils.CreateAccountingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountingRepository {
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    SubscriptionRepository subscriptionRepository;
    final JdbcTemplate jdbc;

    public AccountingRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    RowMapper<Accounting> mapper = (rs, rowNum) -> new Accounting()
            .setId(rs.getInt("id"))
            .setEnd(rs.getDate("end"))
            .setStart(rs.getDate("start"))
            .setClient(clientRepository.get(rs.getInt("client_id")))
            .setSubscription(subscriptionRepository.get(rs.getInt("SUBSCRIPTION_ID")));

    private Accounting one(String sql, Object... args) {
        var res = jdbc.query(sql, mapper, args);
        return res.size() == 0 ? null : res.get(0);
    }

    public List<Accounting> getByClient(int id) {
        return jdbc.query("call getAccountingByClient(?)", mapper, id);

    }

    public Accounting get(int id) {
        return one("call getAccounting(?)", id);
    }

    public void delete(int id) {
        jdbc.update("call deleteAccounting(?)", id);
    }

    public void create(Accounting accounting) {
        jdbc.update("call  createAccounting(?,?,?,?)",
                accounting.getStart(),
                accounting.getEnd(),
                accounting.getClient().getId(),
                accounting.getSubscription().getId()
        );
    }

    public List<Accounting> getAll(){
        return jdbc.query("call getAllAccounting()", mapper);
    }
}
