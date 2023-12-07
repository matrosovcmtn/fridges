package ru.matrosov.fridges.model.dictionary;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(builderClassName = "Builder")
@Data
public class ApplicationModel {
    private Integer id;
    private String customerId;
    private String employeeId;
    private LocalDate creationDate;
}
