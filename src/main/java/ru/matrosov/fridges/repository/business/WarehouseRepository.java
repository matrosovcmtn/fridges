package ru.matrosov.fridges.repository.business;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.matrosov.fridges.model.dictionary.WarehouseModel;

import java.util.List;

@AllArgsConstructor
@Repository
public class WarehouseRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final RowMapper<WarehouseModel> rowMapper;

    @Transactional
    public List<WarehouseModel> findAll() {
        return jdbcTemplate.query("""
                select * from warehouse
                """, rowMapper);
    }

    @Transactional
    public WarehouseModel findById(Integer id) {
        var parameters = new MapSqlParameterSource("id", id);
        return jdbcTemplate.queryForObject("""
                select * from warehouse w where w.id = :id
                """, parameters, rowMapper);
    }
}
