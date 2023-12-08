package ru.matrosov.fridges.repository.business.impl;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.matrosov.fridges.model.dictionary.ItemModel;
import ru.matrosov.fridges.repository.business.ItemRepository;

import java.util.List;

@AllArgsConstructor
@Repository
public class ItemRepositoryImpl implements ItemRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final RowMapper<ItemModel> rowMapper;

    @Transactional
    @Override
    public List<ItemModel> findAll() {
        return jdbcTemplate.query("""
                select * from item
                """, rowMapper);
    }

    @Transactional
    @Override
    public ItemModel findById(Integer id) {
        var parameters = new MapSqlParameterSource("id", id);
        return jdbcTemplate.queryForObject("""
                select * from item i where i.id = :id
                """, parameters, rowMapper);
    }
}
