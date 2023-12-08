package ru.matrosov.fridges.repository.business.impl;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.matrosov.fridges.model.dictionary.DetailModel;
import ru.matrosov.fridges.repository.business.DetailRepository;

import java.util.List;

@AllArgsConstructor
@Repository
public class DetailRepositoryImpl implements DetailRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final RowMapper<DetailModel> rowMapper;

    @Transactional
    @Override
    public List<DetailModel> findAll() {
        return jdbcTemplate.query("""
                select * from detail
                """, rowMapper);
    }

    @Transactional
    @Override
    public DetailModel findById(Integer id) {
        var parameters = new MapSqlParameterSource("id", id);
        return jdbcTemplate.queryForObject("""
                select * from detail d where d.id = :id
                """, parameters, rowMapper);
    }
}
