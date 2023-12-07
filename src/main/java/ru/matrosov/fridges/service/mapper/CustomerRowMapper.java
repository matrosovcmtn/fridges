package ru.matrosov.fridges.service.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import ru.matrosov.fridges.model.dictionary.CustomerModel;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class CustomerRowMapper implements RowMapper<CustomerModel> {
    @Override
    public CustomerModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        return CustomerModel.builder()
                .id(rs.getInt("ID"))
                .firstName(rs.getString("FIRST_NAME"))
                .secondName(rs.getString("SECOND_NAME"))
                .middleName(rs.getString("MIDDLE_NAME"))
                .phoneNumber(rs.getString("PHONE_NUMBER"))
                .build();
    }
}
