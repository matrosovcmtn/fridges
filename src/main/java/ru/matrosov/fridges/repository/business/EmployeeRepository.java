package ru.matrosov.fridges.repository.business;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.matrosov.fridges.model.dictionary.EmployeeModel;

import java.util.List;

@AllArgsConstructor
@Repository
public class EmployeeRepository {
    private static final String FIRST_NAME = "firstName";
    private static final String SECOND_NAME = "secondName";
    private static final String MIDDLE_NAME = "middleName";
    private static final String PHONE_NUMBER = "phoneNumber";
    private static final String FULL_NAME = "fullName";
    private static final String WAREHOUSE_ID = "warehouseId";
    private static final String SPEC_ID = "specId";

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

    @Transactional
    public int save(EmployeeModel employeeModel) {
        var parameters = new MapSqlParameterSource()
                .addValue(FIRST_NAME, employeeModel.getFirstName())
                .addValue(SECOND_NAME, employeeModel.getSecondName())
                .addValue(MIDDLE_NAME, employeeModel.getMiddleName())
                .addValue(PHONE_NUMBER, employeeModel.getPhoneNumber())
                .addValue(FULL_NAME, employeeModel.getFullName())
                .addValue(WAREHOUSE_ID, employeeModel.getWarehouseId())
                .addValue(SPEC_ID, employeeModel.getSpecId());
        return jdbcTemplate.update("""
                INSERT INTO employee
                    (first_name, second_name, middle_name, phone_number, full_name, warehouse_id, spec_id)
                VALUES
                    (:firstName, :secondName, :middleName, :phoneNumber, :fullName, :warehouseId, :specId);
                """, parameters);
    }
}
