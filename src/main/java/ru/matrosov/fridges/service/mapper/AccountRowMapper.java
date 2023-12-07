package ru.matrosov.fridges.service.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import ru.matrosov.fridges.model.security.AccountModel;
import ru.matrosov.fridges.model.security.enumeration.Role;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class AccountRowMapper implements RowMapper<AccountModel> {
    @Override
    public AccountModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        return AccountModel.builder()
                .id(rs.getInt("ID"))
                .username(rs.getString("USERNAME"))
                .email(rs.getString("EMAIL"))
                .password(rs.getString("PASSWORD"))
                .role(Role.valueOf(rs.getString("ROLE")))
                .build();
    }
}
