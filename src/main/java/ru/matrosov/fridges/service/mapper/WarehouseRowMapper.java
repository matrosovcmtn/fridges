package ru.matrosov.fridges.service.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import ru.matrosov.fridges.model.dictionary.WarehouseModel;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class WarehouseRowMapper implements RowMapper<WarehouseModel> {
    @Override
    public WarehouseModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        return WarehouseModel.builder()
                .id(rs.getInt("ID"))
                .detailsInformation(rs.getString("DETAILS_INFORMATION"))
                .warehouseInformation(rs.getString("WAREHOUSE_INFORMATION"))
                .build();
    }
}
