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
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final RowMapper<AccountModel> rowMapper;

    @Transactional
    public Optional<AccountModel> findByEmail(String email) {
        var parameters = new MapSqlParameterSource("email", email);
        return Optional.of(jdbcTemplate.queryForObject("""
                select * from account a where a.email = :email
                """, parameters, rowMapper));
    }

    @Transactional
    public int save(AccountModel accountModel) {
        var parameters = new MapSqlParameterSource()
                .addValue("username", accountModel.getUsername())
                .addValue("email", accountModel.getEmail())
                .addValue("password", accountModel.getPassword())
                .addValue("role", accountModel.getRole().name());
        return jdbcTemplate.update("""
                INSERT INTO account(username, email, password, role)
                	VALUES (:username, :email, :password, :role);
                """, parameters);
    }
}
