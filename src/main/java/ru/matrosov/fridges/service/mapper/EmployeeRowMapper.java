package ru.matrosov.fridges.service.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import ru.matrosov.fridges.model.EmployeeModel;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class EmployeeRowMapper implements RowMapper<EmployeeModel> {

    @Override
    public EmployeeModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        return EmployeeModel.builder()
                .id(rs.getInt("ID"))
                .firstName(rs.getString("FIRST_NAME"))
                .secondName(rs.getString("SECOND_NAME"))
                .middleName(rs.getString("MIDDLE_NAME"))
                .phoneNumber(rs.getString("PHONE_NUMBER"))
                .fullName(rs.getString("FULL_NAME"))
                .warehouseId(rs.getInt("WAREHOUSE_ID"))
                .specId(rs.getInt("SPEC_ID"))
                .build();
    }
}
