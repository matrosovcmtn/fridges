package ru.matrosov.fridges.repository.business.impl;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.matrosov.fridges.model.dictionary.CustomerModel;
import ru.matrosov.fridges.repository.business.CustomerRepository;

import java.util.List;

@AllArgsConstructor
@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final RowMapper<CustomerModel> rowMapper;

    @Transactional
    @Override
    public List<CustomerModel> findAll() {
        return jdbcTemplate.query("""
                select * from customer
                """, rowMapper);
    }

    @Transactional
    @Override
    public CustomerModel findById(Integer id) {
        var parameters = new MapSqlParameterSource("id", id);
        return jdbcTemplate.queryForObject("""
                select * from customer c where c.id = :id
                """, parameters, rowMapper);
    }
}
