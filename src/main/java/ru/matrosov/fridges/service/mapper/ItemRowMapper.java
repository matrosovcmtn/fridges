package ru.matrosov.fridges.service.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import ru.matrosov.fridges.model.dictionary.ItemModel;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class ItemRowMapper implements RowMapper<ItemModel> {
    @Override
    public ItemModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        return ItemModel.builder()
                .id(rs.getInt("ID"))
                .name(rs.getString("NAME"))
                .quantity(rs.getInt("QUANTITY"))
                .warehouseId(rs.getInt("WAREHOUSE_ID"))
                .build();
    }
}
