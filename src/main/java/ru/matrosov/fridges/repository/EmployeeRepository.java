package ru.matrosov.fridges.repository;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.matrosov.fridges.model.EmployeeModel;

import java.util.List;

@AllArgsConstructor
@Repository
public class EmployeeRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final RowMapper<EmployeeModel> rowMapper;

    @Transactional
    public List<EmployeeModel> findAll() {
        return jdbcTemplate.query("""
                select * from employee
                """, rowMapper);
    }

    @Transactional
    public EmployeeModel findById(Integer id) {
        var parameters = new MapSqlParameterSource("id", id);
        return jdbcTemplate.queryForObject("""
                select * from employee e where e.id = :id
                """, parameters, rowMapper);
    }
}
