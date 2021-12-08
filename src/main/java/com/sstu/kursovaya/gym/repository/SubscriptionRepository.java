package com.sstu.kursovaya.gym.repository;

import com.sstu.kursovaya.gym.model.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class  SubscriptionRepository {
    final JdbcTemplate jdbc;

    @Autowired
    private ContinuanceRepository continuanceRepository;
    @Autowired
    private HallRepository hallRepository;
    @Autowired
    private TrainerRepository trainerRepository;

    public SubscriptionRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    private final RowMapper<Subscription> mapper = (rs, rowNum) -> new Subscription()
            .setId(rs.getInt("id"))
            .setName(rs.getString("name"))
            .setContinuance(continuanceRepository.get(rs.getInt("continuance_id")))
            .setHall(hallRepository.get(rs.getInt("hall_id")))
            .setTrainer(trainerRepository.get(rs.getInt("trainer_id")));

    private Subscription one(String sql, Object... args) {
        List<Integer> list = new ArrayList<>();

        var res = jdbc.query(sql, mapper, args);
        return res.size() == 0 ? null : res.get(0);
    }

    public void create(Subscription subscription) {
        jdbc.update("call createSubscription(?,?,?,?,?)",
                subscription.getName(),
                subscription.getPrice(),
                subscription.getContinuance().getId(),
                subscription.getHall().getId(),
                subscription.getTrainer().getId()
        );
    }

    public List<Subscription> getAll() {
        return jdbc.query("call getAllSubscription()", mapper);
    }

    public Subscription get(int id) {
        return one("call getSubscriptionById(?)", id);
    }

    public void delete(int id) {
        jdbc.update("call deleteSubscription(?)", id);
    }
}
