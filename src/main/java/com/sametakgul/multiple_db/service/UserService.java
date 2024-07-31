package com.sametakgul.multiple_db.service;

import java.util.List;


import com.sametakgul.multiple_db.model.mysql.MySQLUser;
import com.sametakgul.multiple_db.model.postgresql.PostgreSQLUser;
import com.sametakgul.multiple_db.repository.mysql.MySQLUserRepository;
import com.sametakgul.multiple_db.repository.postgresql.PostgreSQLUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserService {

    private final MySQLUserRepository mySQLUserRepository;

    private final PostgreSQLUserRepository postgresUserRepository;

    public List<MySQLUser> getAllMySQLUsers() {
        return mySQLUserRepository.findAll();
    }

    public MySQLUser saveMySQLUser(MySQLUser user) {
        return mySQLUserRepository.save(user);
    }

    public List<PostgreSQLUser> getAllPostgresUsers() {
        return postgresUserRepository.findAll();
    }

    public PostgreSQLUser savePostgresUser(PostgreSQLUser user) {
        return postgresUserRepository.save(user);
    }
}