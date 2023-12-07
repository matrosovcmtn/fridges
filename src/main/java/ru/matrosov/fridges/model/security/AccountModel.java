package ru.matrosov.fridges.model.security;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.matrosov.fridges.model.security.enumeration.Role;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(builderClassName = "Builder")
@Data
public class AccountModel {
    Integer id;
    String username;
    String email;
    String password;
    Role role;
}
