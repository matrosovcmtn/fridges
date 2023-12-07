package ru.matrosov.fridges.model.dictionary;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(builderClassName = "Builder")
@Data
public class CustomerModel {
    private Integer id;
    private String firstName;
    private String secondName;
    private String middleName;
    private String phoneNumber;
}
