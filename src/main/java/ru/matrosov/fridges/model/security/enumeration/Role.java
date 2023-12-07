package ru.matrosov.fridges.model.security.enumeration;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

public enum Role {
    @JsonEnumDefaultValue
    USER,
    ADMIN
}
