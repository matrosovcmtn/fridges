package ru.matrosov.fridges.service.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import ru.matrosov.fridges.model.ProductModel;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class ProductRowMapper implements RowMapper<ProductModel> {
    @Override
    public ProductModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        return ProductModel.builder()
                .id(rs.getInt("ID"))
                .itemName(rs.getString("ITEM_NAME"))
                .itemInformation(rs.getString("ITEM_INFORMATION"))
                .build();
    }
}
