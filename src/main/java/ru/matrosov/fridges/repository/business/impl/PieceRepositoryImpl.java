package ru.matrosov.fridges.repository.business.impl;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.matrosov.fridges.model.dictionary.PieceModel;
import ru.matrosov.fridges.repository.business.PieceRepository;

import java.util.List;

@AllArgsConstructor
@Repository
public class PieceRepositoryImpl implements PieceRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final RowMapper<PieceModel> rowMapper;

    @Transactional
    @Override
    public List<PieceModel> findAll() {
        return jdbcTemplate.query("""
                select * from piece
                """, rowMapper);
    }

    @Transactional
    @Override
    public PieceModel findById(Integer id) {
        var parameters = new MapSqlParameterSource("id", id);
        return jdbcTemplate.queryForObject("""
                select * from piece p where p.id = :id
                """, parameters, rowMapper);
    }
}
