package ru.matrosov.fridges.service.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import ru.matrosov.fridges.model.DetailModel;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class DetailRowMapper implements RowMapper<DetailModel> {
    @Override
    public DetailModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        return DetailModel.builder()
                .id(rs.getInt("ID"))
                .name(rs.getString("NAME"))
                .quantity(rs.getInt("QUANTITY"))
                .warehouseId(rs.getInt("WAREHOUSE_ID"))
                .build();
    }
}
