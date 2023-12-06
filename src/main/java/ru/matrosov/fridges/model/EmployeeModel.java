package ru.matrosov.fridges.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(builderClassName = "Builder")
@Data
public class EmployeeModel {
    private int id;
    private String firstName;
    private String secondName;
    private String middleName;
    private String phoneNumber;
    private String fullName;
    private int warehouseId;
    private int specId;
}
