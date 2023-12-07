package ru.matrosov.fridges.repository;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.matrosov.fridges.model.ProductModel;

import java.util.List;

@AllArgsConstructor
@Repository
public class ProductRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final RowMapper<ProductModel> rowMapper;

    @Transactional
    public List<ProductModel> findAll() {
        return jdbcTemplate.query("""
                select * from product
                """, rowMapper);
    }

    @Transactional
    public ProductModel findById(Integer id) {
        var parameters = new MapSqlParameterSource("id", id);
        return jdbcTemplate.queryForObject("""
                select * from product p where p.id = :id
                """, parameters, rowMapper);
    }
}
