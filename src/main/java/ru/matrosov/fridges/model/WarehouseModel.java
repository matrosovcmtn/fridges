package ru.matrosov.fridges.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(builderClassName = "Builder")
@Data
public class WarehouseModel {
    private Integer id;
    private String warehouseInformation;
    private String detailsInformation;
}
