package ru.matrosov.fridges.repository;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.matrosov.fridges.model.PieceModel;

import java.util.List;

@AllArgsConstructor
@Repository
public class PieceRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final RowMapper<PieceModel> rowMapper;

    @Transactional
    public List<PieceModel> findAll() {
        return jdbcTemplate.query("""
                select * from piece
                """, rowMapper);
    }

    @Transactional
    public PieceModel findById(Integer id) {
        var parameters = new MapSqlParameterSource("id", id);
        return jdbcTemplate.queryForObject("""
                select * from piece p where p.id = :id
                """, parameters, rowMapper);
    }
}
