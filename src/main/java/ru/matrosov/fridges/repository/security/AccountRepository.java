package ru.matrosov.fridges.repository.security;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.matrosov.fridges.model.security.AccountModel;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class AccountRepository {
    private static final String USERNAME = "username";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";
    private static final String ROLE = "role";
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final RowMapper<AccountModel> rowMapper;

    @Transactional
    public Optional<AccountModel> findByEmail(String email) {
        var parameters = new MapSqlParameterSource(EMAIL, email);
        return Optional.of(jdbcTemplate.queryForObject("""
                select * from account a where a.email = :email
                """, parameters, rowMapper));
    }

    @Transactional
    public int save(AccountModel accountModel) {
        var parameters = new MapSqlParameterSource()
                .addValue(USERNAME, accountModel.getUsername())
                .addValue(EMAIL, accountModel.getEmail())
                .addValue(PASSWORD, accountModel.getPassword())
                .addValue(ROLE, accountModel.getRole().name());
        return jdbcTemplate.update("""
                INSERT INTO account(username, email, password, role)
                	VALUES (:username, :email, :password, :role);
                """, parameters);
    }
}
