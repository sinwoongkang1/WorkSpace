package org.example.springjdbc03;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionTemplate;

@Repository
@RequiredArgsConstructor
public class UserService {
    private final JdbcTemplate jdbcTemplate;
    private final TransactionTemplate transactionTemplate;

    public void executeComplexBusinessProcess(String name, String email){
        transactionTemplate.execute(status -> {
            jdbcTemplate.update("insert into users (name, email) values (?, ?)", name, email);
            if(email.contains("error")){
                status.setRollbackOnly();
                throw new RuntimeException("error");
            }
            jdbcTemplate.update("update users set email = ? where name = ?", "update.email@example.com", name);
            return null;
        });

    }
}
