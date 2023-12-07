package ru.matrosov.fridges.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(builderClassName = "Builder")
@Data
public class ItemModel {
    private Integer id;
    private String name;
    private Integer quantity;
    private Integer warehouseId;
}
