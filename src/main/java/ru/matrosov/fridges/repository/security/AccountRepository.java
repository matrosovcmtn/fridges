package ru.matrosov.fridges.repository.security;

import ru.matrosov.fridges.model.security.AccountModel;

import java.util.Optional;

public interface AccountRepository {
    Optional<AccountModel> findByEmail(String email);

    int save(AccountModel accountModel);
}
