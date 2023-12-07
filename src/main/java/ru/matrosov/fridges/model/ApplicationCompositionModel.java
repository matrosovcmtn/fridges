package ru.matrosov.fridges.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(builderClassName = "Builder")
@Data
public class ApplicationCompositionModel {
    private Integer id;
    private Integer quantity;
    private Integer applicationId;
    private LocalDate creationDate;
}
